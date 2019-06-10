package morning;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setHeader("refresh","2");
//        response.setHeader("refresh","3；/adv.html");
//        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Type","text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print("<html>" +
                "<head><title>响应数据</title></head>" +
                "<body>访问到了servlet...</body>"+"</html>");
    }
}
