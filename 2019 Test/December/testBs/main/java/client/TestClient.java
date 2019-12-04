package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) {
        // /subject/about/index.html
//         * 建立一个Socket对象，连接网络端口
        Socket socket = null;
        InputStream is = null;
        OutputStream ops = null;
        try {
             socket = new Socket("www.baidu.com",8080);
        //         * 后期输出流对象
            is = socket.getInputStream();
        //         * 获取输出流对象
            ops = socket.getOutputStream();
        //         * 将http协议的请求部分发送到服务端
            ops.write("GET /index.html HTTP/1.1\n".getBytes());
            ops.write("HOST:www.baidu.com\\n".getBytes());
            ops.write("\\n".getBytes());
        //         * 读取来自服务端的数据打印到控制台
            int i = is.read();
            while (i!=-1){
                System.out.print((char) i);
                i = is.read();
            }
        //         * 释放资源
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null!=is) {
                    ops.close();
                }
                if(null!=ops) {
                    is.close();
                }
                if(socket!=null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
