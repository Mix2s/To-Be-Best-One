package src.com.io;

import java.io.*;

public class TestFile {
    public static void main(String[] args) throws IOException {
    }
    private static void copyFile(InputStream in,OutputStream out) throws IOException {
        System.out.println("拷贝开始");
        long start = System.nanoTime();
        int len = 0;
        byte[] data = new byte[1024];
        while((in.read())!=-1){
            out.write(data,0,len);             //边读编写
        }
        long end = System.nanoTime();
        System.out.println("耗时"+(end-start)+"纳秒");

    }
    public static void code1(){

    }
    public static void code(){
        File file = new File("D:/wudi/test.txt");
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            int len = 0;
            byte[] data = new byte[1];
            len = in.read(data);
            String ss = new String(data,0,len);
            System.out.println("文件内容"+ss);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write("zhongji".getBytes());  //写入字节文件流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
