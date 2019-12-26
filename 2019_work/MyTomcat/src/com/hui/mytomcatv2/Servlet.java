package com.hui.mytomcatv2;

import java.io.InputStream;
import java.io.OutputStream;

public interface Servlet {
    //初始化
    public void init();
    //服务
    public void Service(InputStream inputStream, OutputStream outputStream);
    //初始化
    public void destory();
}

