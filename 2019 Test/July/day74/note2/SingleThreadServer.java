package bite.note2;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
    单线程版本聊天室
    服务器端
 */
public class SingleThreadServer{
    public static void main(String[] args) throws IOException {
         //建立基站
        ServerSocket serverSocket = new ServerSocket(7777);  //6666服务端接收客服端端口号
        //等待客户连接
        System.out.println("等待连接-----");
        Socket socket = serverSocket.accept();  //
        System.out.println("连接成功-----客服端端口号："+socket.getPort());
        //拿到客户端输入输出流
        //使用输入流 读取客户端信息
        Scanner in = new Scanner(socket.getInputStream());
        if(in.hasNext()){
            String str = in.nextLine();
            System.out.println("客服端发送消息："+str);
        }
        //向客户端发送消息
        PrintStream out = new PrintStream(socket.getOutputStream());
        in.close();
        out.close();
        socket.close();
    }
}
