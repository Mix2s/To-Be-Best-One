package cn.bite.travel.web.servlet;

import cn.bite.travel.service.UserService;
import cn.bite.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1.获取code激活码
 * 判断激活码 是否存在
 * 存在不为null 激活用户
 * 3.判断用户是否为空
 */
@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1接受激活码
        String code = request.getParameter("code");
        //判断是否存在激活码
        if(code!=null){
            //调用service完成激活
            UserService userService = new UserServiceImpl();
            boolean flag = userService.active(code);
            //提示信息（向浏览器相应内容）
            String msg = "";
            if(flag){
                //激活成功
                msg="激活成功,请<a href='login.html'>登录</a>";
            }else{
                //激活失败
                msg="登录失败,未激活";
            }
            //设置中文乱码
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
