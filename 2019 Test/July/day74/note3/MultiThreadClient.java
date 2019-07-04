package bite.note3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 多线程版本客服端
 */
public class MultiThreadClient {
    private static class SendMsgToServer implements Runnable{
        //发送信息线程
        private Socket client;

        public SendMsgToServer(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            System.out.print("请输入信息：");
            Scanner in = new Scanner(System.in);
            PrintStream Clientout = null;
            try {                                                       //autoFilush自动刷新缓冲区
                Clientout =  new PrintStream(client.getOutputStream(),true,"utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true){
                if(in.hasNext()){
                    System.out.print("输入信息：");
                    String str = in.nextLine();
                    //将信息发送服务器端
                    Clientout.println(str);
                    //客户端结束
                    if(str.contains("GG")){
                        System.out.println("客服端退出！！！");
                        break;
                    }
                }
            }
            in.close();
            Clientout.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static class ReadMsgThreadServer implements Runnable{
        //读取信息线程
        private Socket client;
        public ReadMsgThreadServer(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            Scanner in = null;
            try {
                in  = new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true){
                if(client.isClosed()){
                    System.out.println("客服端关闭结束通信!!!");
                    break;
                }
                if(in.hasNext()){
                    String str = in.nextLine();
                    System.out.println("服务器发送信息："+str);
                }
            }
            in.close();
        }
    }
    public static void main(String[] args) throws IOException {
        //与服务器建立连接
        Socket client = new Socket("127.0.0.1",6666);
        //新建读取线程
        Thread readThread = new Thread(new ReadMsgThreadServer(client));
        //新建发送线程
        Thread sendThread  = new Thread(new SendMsgToServer(client));
        readThread.start();
        sendThread.start();
    }
}
