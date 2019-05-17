package src.javaTest;

import java.io.*;
import java.util.Scanner;
class Myprint{
    private OutputStream out;
    public Myprint(OutputStream out){
        this.out = out;
    }
    public void print(String str) throws IOException {
        this.out.write(str.getBytes());
    }
}
public class day516 {
    public static void main(String[] args) throws Exception {
            code1();
    }
    public static void code1() throws Exception {
        File file = new File("D:/wudi/shuai.txt");
        PrintStream ps = new PrintStream(new FileOutputStream(file));       //创建 打印流
        Scanner sc = new Scanner(new FileInputStream(file));            //创建 输入流
        ps.println(123);
        ps.println("无敌辉");
        ps.println('a');
        while(sc.hasNext()){
            String ss = sc.next();
            System.out.println(ss);
            System.err.println(ss);
        }
        ps.close();
        sc.close();
    }
}
