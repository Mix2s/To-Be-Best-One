package com.hui.mytomcatv2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BBServlect implements Servlet{
    @Override
    public void init() {
        System.out.println("bbServlect-----init");
    }

    @Override
    public void Service(InputStream is, OutputStream ops) {
        System.out.println("bbServlet------service");
        try {
            ops.write("This is BBServlet".getBytes());
            ops.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destory() {
        System.out.println("bbServlet------destory");
    }
}
