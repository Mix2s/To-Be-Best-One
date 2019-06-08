package morning;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeDemoServlet extends HttpServlet {
    public LifeDemoServlet(){
        System.out.println("servlet被创建...");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet被初始化...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用servie方法...");
    }

    @Override
    public void destroy() {
        System.out.println("servlet被销毁。。。");
    }
}
