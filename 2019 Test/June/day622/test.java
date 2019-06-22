package com.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Cookie基本使用
 */
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //解决中文乱码
            response.setContentType("text/htm;charset=utf-8");
            PrintWriter writer = response.getWriter();
            
            //从cookie数组获取指定cookie
            Cookie c = getCookieByName("list",request.getCookies());

            if(c==null){
                writer.print("第一次访问");
            }else{
                String value = c.getValue();
                long time = Long.parseLong(value);
                Date date = new Date(time);
                writer.print("上一次访问时间:"+date.toLocaleString());
            }
            c = new Cookie("lastname",new Date().getTime()+"");

            c.setMaxAge(3000);

            response.addCookie(c);

            writer.print("写回");
            /*response.setContentType("text/html;charset=utf-8");
            Cookie cookie = new Cookie("akey","avalue");
            response.addCookie(cookie);

            response.getWriter().print("cookie写回");

            Cookie[] cookies = request.getCookies();
            if(cookies!=null){
                for(Cookie ck:cookies){
                    System.out.println(ck.getName()+"+++++"+ck.getValue());
                }
            }*/
    }

    private Cookie getCookieByName(String name, Cookie[] cookies) {
            /*
              *从浏览器中存在的cookie数组获取指定名称的cookie
              *
             */
            if(cookies!=null){
                for(Cookie cookie : cookies){
                    if(name.equals(cookie.getName())){
                        return cookie;
                    }
                }
            }
        return null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
