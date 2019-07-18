package test.web;

import test.domain.User;
import test.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  登录业务
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置编码
        response.setContentType("test/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //获取参数数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //根据用户名密码查询 调用service
        UserService service  = new UserService();
        User user = service.login(username,password);
        //判断user是否为空
        if(user==null){
            writer.write("用户名或者密码错误");
        }else{
            writer.write("登陆成功"+user.getUsername()+"欢迎回来");
        }

        //接收参数
            //调用service 获取 User对象
            //判断User是否为空
    }
}
