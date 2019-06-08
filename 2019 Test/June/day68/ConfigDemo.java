package morning;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigDemo extends HttpServlet {
    /*private ServletConfig config;
    String path = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        path = config.getInitParameter("path");
    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String path = null;
//            BufferedReader br  = new BufferedReader(new FileReader("D:/aaa.txt"));
//            String line = null;
//            while((line = br.readLine())!=null){
//                System.out.println(line);
//            }
        String path = null;
        ServletConfig servletConfig = this.getServletConfig();
        path = servletConfig.getInitParameter("path");
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;
        while((line = br.readLine())!=null)
            System.out.println(line);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
