package bite.note5;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(6666);
        System.out.println("服务器启动");

        Socket socket = serversocket.accept();

        System.out.println("连接畅通"+socket.getPort());

        InputStream inputStream = socket.getInputStream();
        Scanner sc = new Scanner(inputStream);
        String mess = sc.nextLine();
        System.out.println("收到消息"+mess);
    }
}
