package cn.bite.travel.web.servlet;

import cn.bite.travel.domain.ResultInfo;
import cn.bite.travel.domain.User;
import cn.bite.travel.service.UserService;
import cn.bite.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registUserServlet")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //加入验证码的操作
            //获取前台页面验证码
        String check = request.getParameter("check");
        //从session域 获取
        String checkcode_server = (String)request.getSession().getAttribute("CHECKCODE_SERVER");

        //一次性验证 防止验证码复用
        request.getSession().removeAttribute("CHECKCODE_SERVER");

        //如果验证码不一致
        //放置空指针

        if(checkcode_server==null||!check.equalsIgnoreCase(checkcode_server)){
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
            BeanUtils.populate(user,map);
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
        if(flag){
            //注册成功
            resultInfo.setFlag(true);
        }else{
            //注册失败
            resultInfo.setFlag(false);
            //提示信息
            resultInfo.setErrorMsg("注册失败");
        }

        //使用json支持 json:jsonLib，Gson，fastJson 创建json解析对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        //设置服务器响应格式
        response.setContentType("application/json;charset=utf-8");

        //4.服务器响应前端
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
