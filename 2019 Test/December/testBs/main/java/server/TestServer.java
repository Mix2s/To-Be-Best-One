package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
//        /*
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream ops = null;
        try {
            //        创建ServerSocket对象监听8080端口
            serverSocket = new ServerSocket(8080);
           while (true){
               //        等待来自客户端的请求获取和客户端对应的Socket对象
               socket = serverSocket.accept();
               //        获取Socket对象获取到输入流对象
               ops = socket.getOutputStream();
               //        获取输出流对象将http协议响应部分发送到客户端
               ops.write("HTTP/1.1 200 OK\n".getBytes());
               ops.write("Content-Type:test/html;charset=utf-8\n".getBytes());
               ops.write("Server:Apache-Coyote/1,1\n".getBytes());
               ops.write("\n\n".getBytes());
               StringBuffer sb = new StringBuffer();
               sb.append("<html>");
               sb.append("<head><title>我是标题</title></head>");
               sb.append("<body>");
               sb.append("无敌辉");
               sb.append("</body>");
               sb.append("</html>");
               ops.write(sb.toString().getBytes());
               ops.flush();
           }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //        释放资源

            try {
                if(null!=ops) {
                    ops.close();
                }
                if(null!=socket){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //         */
        }
    }
}
