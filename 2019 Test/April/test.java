package src.com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
class tt implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("wudihui");
    }
}

public class TestFile {
    public static void main(String[] args) throws IOException {
        //1拿到终端对象
        File file = new File("D:/wudi/test.txt");
        OutputStream out = new FileOutputStream(file);
        //根据柳紫丽华实例对象
        out.write("wudaaihui".getBytes());
        out.close();
    }
    private static void listAllFiles(File file){
        if(file !=null){                //如果这个传入的文件对象不为空
            if(file.isDirectory()){         //如果这个对象为文件夹
                File[] files = file.listFiles();        //拿到这个文件夹子目录所有文件对象
                if(files!=null){
                    for(File i:files){          //遍历这个文件夹的内容
                        listAllFiles(i);        //递归文件夹内所有文件
                    }
                }
            }else{
                System.out.println(file);       //直到不为文件夹 打印
            }
        }
    }
    public static void code1() throws IOException {

        File file = new File("D:/test.txt");
        long start = System.currentTimeMillis();
        //listAllFiles(file);
        long end  =System.currentTimeMillis();
        System.out.println("时间"+(end-start)+"毫秒");
        File[] files = file.listFiles();
        for (File i:files
        ) {
            System.out.println(i);
        }
        //System.out.println(file.exists());
        //file.createNewFile();
        //file.delete();
        if(file.exists()){
            file.delete();
        }else{
            file.createNewFile();
        }
        //file.separator;

        if(file.getParentFile().exists()){

        }else{
            file.getParentFile().mkdirs();
        }
        if(file.exists()){
            file.delete();
        }else{
            file.createNewFile();
        }

        if(file.exists()&&file.isFile()) {
            long data = file.lastModified();
            Date data1 = new Date(data);
            System.out.println(file.length());
            System.out.println(data1);
        }
    }
}asdasd
