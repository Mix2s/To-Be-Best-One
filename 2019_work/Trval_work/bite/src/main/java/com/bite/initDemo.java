package com.bite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class initDemo extends HttpServlet {
    private static int count = 1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //利用Sychrinized
        synchronized(initDemo.class){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("当前位置"+ count++ +"位");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //或者使用静态同步代码块解决  相当于锁 当前类.class 如果是非静态的 this
    public static synchronized void method(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("当前位置"+ count++ +"位");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
