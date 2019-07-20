package cn.bite.travel.web.servlet;

import cn.bite.travel.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1直接从session获取用户对象
        Object user = request.getSession().getAttribute("user");

        if(user!=null){
            //将user对象响应到前台 header.html
            ObjectMapper mapper = new ObjectMapper();
            //支持json
            response.setContentType("application/json;charset=utf-8");

            mapper.writeValue(response.getOutputStream(),user);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
