package src.com.io;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class TestFile1 {
    public static void main(String[] args) throws IOException {
        String msg = "wudihui";
        InputStream in =
                new ByteArrayInputStream(msg.getBytes());
        OutputStream out =
                new ByteOutputStream();
        int len=0;
        while((len=in.read())!=-1){
            out.write(Character.toUpperCase(len));
        }
        System.out.println(out);
        in.close();
        out.close();
        
    }
    public static void code1() throws IOException {

        File file  = new File("D:/wudi/test.txt");
        Writer writer = new FileWriter(file);
        writer.write("五毒");
        writer.close();
        System.getProperties().list(System.out);
    }
}
