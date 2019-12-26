package com.hui.mytomcatv2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TestServer {
    // 定义存放 服务端webcontent 目录绝对路径
    public static String WEB_ROOT=System.getProperty("user.dir")+"\\"+"WebContent";
    //存放本次静态页面名称
    private static String url = "";
    //静态类型Map 存储服务端conf.propertie配置信息
    private static Map<String,String> map = new HashMap<String,String>();

    static{
        //启动服务器之前 配置参数
        //创建一个Properties对象
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(WEB_ROOT+"\\conf.properties"));
            //加载WebContent目录下conf.propertie文件
            Set set = properties.keySet();
            //将配置文件中的数据读取到MAP中
            Iterator it = set.iterator();
            while (it.hasNext()){
                String key = (String)it.next();
                String value = properties.getProperty(key);
                map.put(key,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
       // System.out.println(map);
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream ops = null;
        try {
            serverSocket = new ServerSocket(8080);
            while (true){
                //获取客户端 socket对象
                 socket = serverSocket.accept();
                 is = socket.getInputStream();
                 ops = socket.getOutputStream();
                parse(is);
                 //获取HTTP协议请求部分 窃取客户端访问的资源名称 将资源名称赋值给url
                if(null!=url){
                    if(url.indexOf(".")!=-1){
                        //发送静态资源
                        sendStaticResource(ops);
                    }else{
                        //发送动态资源
                        sendDynamicResource(is,ops);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(null!=is){
                    is.close();
                }
                if(null!=ops){
                    ops.close();
                }
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 动态资源 http响应行 响应头发送到客户端
     * @param is
     * @param ops
     */
    private static void sendDynamicResource(InputStream is, OutputStream ops) throws IOException {
        //判断map中是否存在key key是否和本次请求路径一致
        ops.write("HTTP/1.1 200 OK\n".getBytes());
        ops.write("Server:Apache\n".getBytes());
        ops.write("Content-type:text/html;charset=utf-8\n".getBytes());
        ops.write("\n".getBytes());
        //如果包含指定的key 获取到MAP中key对应的value部分
        System.out.println(map.get("aa"));
        if(map.containsKey(url)){
            String value = map.get(url);
            System.out.println(value);
            //通过反射将地应道java程序加载到内存
            Class aClass = null;
            try {
                aClass = Class.forName(value);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(aClass);
            Servlet servlet = null;
            try {
                servlet = (Servlet) aClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //执行init方法
            servlet.init();
            //执行service方法
            servlet.Service(is,ops);
        }
    }

    /**
     * //发送静态资源
     * @param ops
     */
    private static void sendStaticResource(OutputStream ops) {
//        定义字节数组 存放请求静态资源内容
        byte[] bytes = new byte[2048];
//        定义文件输入流用户获取静态资源内容
        FileInputStream fis = null;

//        创建文件对象file 代表本次请求的资源
         File file = new File(WEB_ROOT,url);
//        判断
//            文件存在
        try {
            if (file.exists()) {
                //                向客户端输出http 要求请的资源
                ops.write("HTTP/1.1 200 OK\n".getBytes());
                ops.write("Server:apache-Coyote/1.1\n".getBytes());
                ops.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                ops.write("\n".getBytes());
                //                获取文件输入流对象
                fis = new FileInputStream(file);
                //                读取静态资源
                int ch = fis.read(bytes);
                while (ch != -1) {
                    //                将读取到数组中的内容通过输出流发送到客户端
                    ops.write(bytes, 0, ch);
                    ch = fis.read(bytes);
                }
            } else {
 //             文件不存在
//                向客户端响应文件不存在
                ops.write("HTTP/1.1 200 NOT FOUND\n".getBytes());
                ops.write("Server:apache-Coyote/1.1\n".getBytes());
                ops.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                ops.write("\n".getBytes());
                String errorMsg = "file not found";
//          释放文件输入流对象
                ops.write(errorMsg.getBytes());
            }
        } catch (Exception e){
                e.printStackTrace();
        } finally {
            try {
                if(null!=fis){
                    fis.close();
                }
                if(null!=ops){
                    ops.close();
                }
            } catch (IOException e) {

            }
        }
    }

    /**
     *  //获取HTTP协议请求部分 窃取客户端访问的资源名称 将资源名称赋值给url
     * @param is
     */
    private static void parse(InputStream is) throws IOException {
//        定义一个变量存放http协议请求部分数据
        StringBuffer content = new StringBuffer();
//        存放http协议请求部分数据
        byte[] buffer = new byte[2048];
//        变量 i 读取数据到数组中数据量的大小
        int i = -1;
//        读取客户端发送过来的数据 数据读取到字节数组 buffer中 i 代表数据量大小
        i = is.read(buffer);
//        遍历字节数据 将数据中的数据追加到content变量中
        for(int j=0;j<i;j++){
            content.append((char) buffer[j]);
        }
//        打印http协议请求部分数据
        System.out.println(content);
//        截取客户端要求的资源路径demo.html 复制 url
        parseUrl(content.toString());
    }

    /**
     * 截取url路径
     * @param s
     */
    private static void parseUrl(String s) {
//        定义两个变量 存放切割后空格的位置
        int index1,index2;
//        获取http请求部分第一个空格的位置
        index1 = s.indexOf(" ");
        if(index1!=-1){
            //        获取http请求部分第二个空格的位置
            index2 = s.indexOf(" ",index1+1);
            if(index2>index1){
                //        截取字符串获取本次请求资源的名称
                url = s.substring(index1+2,index2);
            }
        }
//        打印本次请求静态资源名称
        System.out.println(url);
    }
}
