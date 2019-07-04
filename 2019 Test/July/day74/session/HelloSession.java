package session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作为域对象使用
 *      不同的servlet之间数据传递
 */
public class HelloSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=utf-8");

        //获取HttpSession对象
            HttpSession session  = request.getSession();
            //session.setAttribute("name","张三");
            List<String> list = new ArrayList<>();
            list.add("javal");
            list.add("wudi");
            list.add("liii");
            session.setAttribute("list",list);
             System.out.println("成功");
    }
}
