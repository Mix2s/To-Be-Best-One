package src.javatest;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    public String classPath = "D:\\workspace\\Java_Test\\src\\javatest\\Member.java";

    /**
     * 实现一个自定义的类加载器，传入类名称，通过指定路径加载
     *
     * @param className 类名称
     * @return 返回的Class对象
     * @throws Exception
     */
    public Class loadData(String className) throws Exception {
        //加载文件信息
        byte[] data = loadClassData(className);
        return super.defineClass(className,data,0,data.length);
    }

    /**
     * 通过指定的文件路径进行类的文件加载，实际上就是进行二进制文件读取
     *
     * @return 类文件数据
     * @throws Exception
     * @param s
     */
    public byte[] loadClassData(String s) throws Exception {
        InputStream input = new FileInputStream("D:\\workspace\\Java_Test\\src\\javatest\\Member.java");
        //取得内容放入字节内容中 进入内存
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int tmp = 0;
        while ((tmp = input.read(data)) != -1) {
            bos.write(data, 0, tmp);
        }
        byte[] result = bos.toByteArray();
        input.close();
        ;
        bos.close();
        return result;
    }

    public byte[] TeacherLoad(String className) {
        String classFile = classPath + className.replace(".", "\\") + ".class";
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            FileInputStream in = new FileInputStream(classFile);
            {
                byte[] buff = new byte[1024];
                int len = -1;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                out.flush();
                return out.toByteArray();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("wudi");
    }
}

