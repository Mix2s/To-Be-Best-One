package bite.note2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客服端
 */
public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        //与服务器建立连接
        Socket client = new Socket("127.0.0.1",7777);
        System.out.println("客户端连接");
        PrintStream out = new PrintStream(client.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        out.print(str);
        out.flush();


        if(sc.hasNext()){
            String str1 = sc.nextLine();
            System.out.println("服务器发送的信息："+str1);
        }

        out.close();
        sc.close();
        client.close();
    }
}
