package com.bite;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.dom4j.io.OutputFormat;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class io_text {
    public static void main(String[] args) throws Exception {
        /**
         * 自定义打印流
         */
        //boolean short char int float double long
        FileOutputStream out = new FileOutputStream("D:/aaa.txt");
        print_Util pp  =new print_Util(out);
        pp.writeString("wudi");
    }

    private static void code2() throws IOException {
        /*
            适合小量数据拷贝
         */
        String fileA = "D:/aaa.txt";
        String fileB = "D:/bbb.txt";
        String fileC = "D:/ccc.txt";
        FileInputStream ain = new FileInputStream(fileA);
        FileInputStream bin = new FileInputStream(fileB);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        FileOutputStream fout = new FileOutputStream(fileC);

        //现将 ain--->bout  b--->bout
        byte[] buff = new byte[4];
        int len = -1;
        while((len = ain.read(buff))!=-1){
            out.write(buff,0,len);
        }
        while((len = bin.read(buff))!=-1){
            out.write(buff,0,len);
        }
        //out---fout
        byte[] joindData = out.toByteArray();
        fout.write(joindData);
        fout.flush();
        ain.close();
        bin.close();
        out.close();
        fout.close();
    }

    private static void code() throws IOException {
        String mess = new String("asdasd");
        ByteArrayInputStream bi = new ByteArrayInputStream(mess.getBytes());
        ByteOutputStream bs = new ByteOutputStream();
        int value = -1;
        while((value = bi.read())!=-1){
            int newVlue = Character.toUpperCase(value);
            bs.write(newVlue);
        }
        byte[] bb = bs.toByteArray();
        System.out.println(new String(bb));
        OutputStream out = new FileOutputStream("D:/aaa.txt");
        out.write("无敌辉".getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }
}
