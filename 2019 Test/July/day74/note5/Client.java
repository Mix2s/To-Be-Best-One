package bite.note5;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",6666);
        System.out.println("客户端连接");

        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        out.print(str);
        out.flush();
    }
}
