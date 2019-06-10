package morning;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ContestDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contest = this.getServletContext();
        String value = contest.getInitParameter("AAA");
        System.out.println(value);

        Enumeration<String> enums = contest.getInitParameterNames();
        while(enums.hasMoreElements()){
            String parameterName = enums.nextElement();
            String parameterValue = contest.getInitParameter(parameterName);
            System.out.println(parameterName+":"+parameterValue);
        }
        System.out.println("-----------------------------------------");
        String contextPath  = request.getContextPath();
        System.out.println(contextPath);
    }
}
