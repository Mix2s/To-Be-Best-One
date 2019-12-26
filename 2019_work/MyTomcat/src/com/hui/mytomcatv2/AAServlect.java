package com.hui.mytomcatv2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AAServlect implements Servlet{
    @Override
    public void init() {
        System.out.println("aaServlect-----init");
    }

    @Override
    public void Service(InputStream is, OutputStream ops) {
        System.out.println("aaServlet------service");
        try {
            ops.write("This is AAServlet".getBytes());
            ops.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destory() {
        System.out.println("aaServlet------destory");
    }
}
