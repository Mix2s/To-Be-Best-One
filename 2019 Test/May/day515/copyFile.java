package src.javaTest;

import java.io.*;

public class CopyFileUtil {
    private CopyFileUtil(){

    }
    public static boolean fileIsExists(String path){
        return new File(path).exists();
    }
    public static void createParentDir(String path){
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
    }
    public static boolean copyFile(String sourcePath,String destPath){
        File inFile = new File(sourcePath);
        File outFile = new File(destPath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(inFile);
            fileOutputStream = new FileOutputStream(outFile);
            copyFileHandle(fileInputStream,fileOutputStream );
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally{
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private static void copyFileHandle(InputStream inputStream, OutputStream outputStream) throws IOException {
        long start = System.currentTimeMillis();
        int tmp = 0;
        while(tmp!=-1){
            tmp = inputStream.read();
            outputStream.write(tmp);
        }
        long end = System.currentTimeMillis();
        System.out.println("拷贝完成耗时"+(end-start)+"毫秒");
    }
}
