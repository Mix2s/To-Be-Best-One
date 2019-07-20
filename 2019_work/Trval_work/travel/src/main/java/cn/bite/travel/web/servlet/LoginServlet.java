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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        //验证码逻辑
        String check = request.getParameter("check");
        String checkcode_server = (String)request.getSession().getAttribute("CHECKCODE_SERVER");


        request.getSession().removeAttribute("CHECKCODE_SERVER");


        if(checkcode_server==null||!check.equalsIgnoreCase(checkcode_server)){
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
        }*/
        //1接收前台参数
        Map<String, String[]> map = request.getParameterMap();
        //2封装user类
        User user = new User();
        try {
            BeanUtils.populate(user,map);
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
        if(u==null){
            //不存在
            info.setFlag(false);
            info.setErrorMsg("用户名密码不匹配");
        }

        //用户存在未激活
        if(u!=null&&!"Y".equals(u.getStatus())){
            //未激活
            info.setFlag(false);
            info.setErrorMsg("当前账号未激活");
        }

        //判断登录成功的情况
        if(u!=null&&"Y".equals(u.getStatus())){
            //登陆成功 u存储到session中
            request.getSession().setAttribute("user",u);
            info.setFlag(true);
        }

        //将当前响应对象解析成json串发送前台
        ObjectMapper mapper = new ObjectMapper();
        //writrValueString(mapper,响应结果对象)
        //writerVlaue(字节输出流.响应结果对象)
        //设置响应格式 支持json格式
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
