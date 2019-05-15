package src.javaTest;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class day515 {
    public static void main(String[] args) throws Exception {
           File[] files =
                   new File[]{new File("D:/wudi/test.txt"),
                           new File("D:/wudi/test1.txt")};
           String[] data = new String[2];
           for(int i=0;i<files.length;i++){
               data[i]=readFile(files[i]);
           }
           StringBuffer buf = new StringBuffer();
           String contetA[] = data[0].split(" ");
           String contetB[] = data[1].split(" ");
           for(int i=0;i<contetA.length;i++){
              buf.append(contetA[i]).append("(").append(contetB)
                      .append(")").append(" ");
           }
            String a = new String(buf);
        System.out.println(a);
        }

    private static String readFile(File file) throws Exception {
        if(file.exists()){
            InputStream input = new FileInputStream(file);
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            int tmp = 0;
            byte[] data = new byte[10];
            while((input.read())!=-1){
                bos.write(data,0,tmp);
            }
            bos.close();
            input.close();
            return new String(bos.toByteArray());
        }
        return null;
    }

    public static void code1() throws Exception {
        String msg = "aaa";
        InputStream input = new ByteArrayInputStream(msg.getBytes());
        OutputStream output = new ByteOutputStream();
        int tmp = 0;
        while((tmp = input.read())!=-1){
            output.write(Character.toUpperCase(tmp));
        }
        System.out.print(output);
        input.close();
        output.close();
        String ss = "D:/wudi/test.txt";
        String dd = "D:/wudi/test1.txt";
        CopyFileUtil.copyFile(ss,dd);
        File file = new File("D:/wudi/test.txt");
        if(file.exists()){
            Reader in = new FileReader(file);
            char[] data = new char[1024];
            int len = in.read(data);
            String result = new String(data,0,len);
            System.out.println("读取"+result);
            in.close();
        }
        if(file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String msg1 = "wudihui";
        Writer out = new FileWriter(file,true);
        out.write(msg);
        out.flush();
        if (file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            OutputStream output1 = new FileOutputStream(file);
            Writer out1 = new OutputStreamWriter(output);
            String msg2= "无敌";
            out.write(msg);
            out.close();
    }
}
}
