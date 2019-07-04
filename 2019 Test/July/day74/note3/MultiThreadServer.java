package bite.note3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端
 */
public class MultiThreadServer {
    //保存所有连接的客户端
    private static Map<String, Socket> clientMap = new ConcurrentHashMap<>();

    private static class ExecuteClientMsg implements Runnable{
        private Socket client;

        public ExecuteClientMsg(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            Scanner in = null;
            try {
                in = new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true){
                if(in.hasNext()){
                    String str = in.nextLine();
                    //注册
                    if(str.startsWith("R:")){
                        //用户注册流程
                        String userName = str.split(":")[1];
                        userReg(userName,client);
                    }
                    //私聊用户名-发送信息
                    if(str.startsWith("S:")){
                        String userName = str.split(":")[1].split("-")[0];
                        String msg = str.split("-")[1];
                        privateChar(userName,"私聊信息："+msg);
                    }
                    //群聊
                    if(str.startsWith("Q:")){
                        String grounChatMsg = str.split(":")[1];
                        groutChat("群聊公屏发送："+grounChatMsg);
                    }
                    if(str.contains("GG")){

                    }
                }
            }
        }
        private void privateChar(String userName,String msg){
            Socket client = clientMap.get(userName);
            try {
                PrintStream out = new PrintStream(client.getOutputStream(),true,"utf-8");
                out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void userReg(String userName,Socket client){
            clientMap.put(userName,client);
            System.out.println("当前聊天室共有"+clientMap.size());
            String msg = "用户"+userName+"   端口"+client.getPort()+"上线";
            System.out.println(msg);
            groutChat(msg);
        }
        private void groutChat(String msg){
            //获取map所有的客户端 拿到输入流
            Collection<Socket> sockets = clientMap.values();
            for(Socket client:sockets){
                try {
                    PrintStream out = new PrintStream(client.getOutputStream(),true,"utf-8");
                    out.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService service = Executors.newFixedThreadPool(20);  //建立固定大小得线程池
        for(int i=0;i<20;i++){
            System.out.println("等待客服端的连接-------");
            Socket client = serverSocket.accept();
            System.out.println("新的客户端连接：端口号"+client.getPort());
            service.submit(new ExecuteClientMsg(client));
        }
        serverSocket.close();
    }
}
