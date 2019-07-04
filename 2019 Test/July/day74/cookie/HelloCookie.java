package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 记录当前用户访问系统时间
         */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        
        Cookie c = getCookieByNmae("lastTime",request.getCookies());
        
        if(c==null){
            writer.print("第一次");
        }else{
            String value = c.getValue();
            long time = Long.parseLong(value);
            Date date = new Date(time);

            writer.print("上次访问时间"+date.toLocaleString());
        }

        c = new Cookie("lastTime",new Date().getTime()+"");
        writer.print("当前时间"+new Date().toLocaleString());

        response.addCookie(c);

        writer.print("时间已经存储");
    }

    private Cookie getCookieByNmae(String name, Cookie[] cookies) {
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
