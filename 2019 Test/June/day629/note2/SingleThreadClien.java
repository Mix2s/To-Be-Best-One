package bite.note2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客服端
 */
public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        //与服务器建立连接
        Socket client = new Socket("127.0.0.1",6666);
        //拿到连接的IO流  使用输出流向服务器发送一条信息
        PrintStream out = new PrintStream(client.getOutputStream());
        //拿到输入流 读取服务器的信息
        Scanner in  = new Scanner(client.getInputStream());
        if(in.hasNext()){
            String str = in.nextLine();
            System.out.println("服务器发送的信息："+str);
        }
        out.close();
        in.close();
        client.close();
    }
}
