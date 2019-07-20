package cn.bite.travel.web.servlet;

import cn.bite.travel.domain.ResultInfo;
import cn.bite.travel.domain.User;
import cn.bite.travel.service.UserService;
import cn.bite.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用户模块
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //加入验证码的操作
        //获取前台页面验证码
        String check = request.getParameter("check");
        //从session域 获取
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");

        //一次性验证 防止验证码复用
        request.getSession().removeAttribute("CHECKCODE_SERVER");

        //如果验证码不一致
        //放置空指针

        if (checkcode_server == null || !check.equalsIgnoreCase(checkcode_server)) {
            //验证码错误
            //创建响应结果对象
            ResultInfo resultInfo = new ResultInfo();

            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码不正确");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            //后面代码不需要执行
            return;
        }
        //1.获取参数数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装User对象
        User user = new User();
        //使用第三方 commons-beanutils 工具类封装工具类
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用Service 查询是否存在该用户
        UserService userService = new UserServiceImpl();
        boolean flag = userService.regist(user);
        //创建响应结果对象
        ResultInfo resultInfo = new ResultInfo();
        //判断用户是否注册成功
        if (flag) {
            //注册成功
            resultInfo.setFlag(true);
        } else {
            //注册失败
            resultInfo.setFlag(false);
            //提示信息
            resultInfo.setErrorMsg("注册失败");
        }

//        //使用json支持 json:jsonLib，Gson，fastJson 创建json解析对象
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(resultInfo);

        String json =  writerValueAsString(resultInfo);
        //设置服务器响应格式
        response.setContentType("application/json;charset=utf-8");

        //4.服务器响应前端
        response.getWriter().write(json);
    }

    /**
     * 用户激活
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1接受激活码
        String code = request.getParameter("code");
        //判断是否存在激活码
        if (code != null) {
            //调用service完成激活
            UserService userService = new UserServiceImpl();
            boolean flag = userService.active(code);
            //提示信息（向浏览器相应内容）
            String msg = "";
            if (flag) {
                //激活成功
                msg = "激活成功,请<a href='login.html'>登录</a>";
            } else {
                //激活失败
                msg = "登录失败,未激活";
            }
            //设置中文乱码
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码逻辑
        String check = request.getParameter("check");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");


        request.getSession().removeAttribute("CHECKCODE_SERVER");


        if (checkcode_server == null || !check.equalsIgnoreCase(checkcode_server)) {
            //验证码错误
            ResultInfo resultInfo = new ResultInfo();

            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码不正确");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            //后面代码不需要执行
            return;
        }
        //1接收前台参数
        Map<String, String[]> map = request.getParameterMap();
        //2封装user类
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调动service层完成查询功能
        UserService userService = new UserServiceImpl();
        User u = userService.findByUsernameAndPassword(user);

        //创建一个访问结果对象
        ResultInfo info = new ResultInfo();

        //4判断查询u是否存在
        if (u == null) {
            //不存在
            info.setFlag(false);
            info.setErrorMsg("用户名密码不匹配");
        }

        //用户存在未激活
        if (u != null && !"Y".equals(u.getStatus())) {
            //未激活
            info.setFlag(false);
            info.setErrorMsg("当前账号未激活");
        }

        //判断登录成功的情况
        if (u != null && "Y".equals(u.getStatus())) {
            //登陆成功 u存储到session中
            request.getSession().setAttribute("user", u);
            info.setFlag(true);
        }

        //将当前响应对象解析成json串发送前台
        ObjectMapper mapper = new ObjectMapper();
        //writrValueString(mapper,响应结果对象)
        //writerVlaue(字节输出流.响应结果对象)
        //设置响应格式 支持json格式
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);
    }

    /**
     * 寻找用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1直接从session获取用户对象
        Object user = request.getSession().getAttribute("user");

        if (user != null) {
            //将user对象响应到前台 header.html
            /*ObjectMapper mapper = new ObjectMapper();
            //支持json
            response.setContentType("application/json;charset=utf-8");

            mapper.writeValue(response.getOutputStream(), user);*/

            //抽取baseServlet方法
            writeVlue(user,response);
        }
    }

    /**
     * 用户退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取session对象 手动删除 session
        request.getSession().invalidate();
        //重定向到login.html
        response.sendRedirect(request.getContextPath()+"/login.html");
    }


}
