package com.ming.springboot.Manager;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ManagerUtil {
    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        InputStream in = ManagerUtil.class.getClassLoader().getResourceAsStream(fileName);

        try {
            properties.load(in);
        } catch (IOException e) {
            System.out.println("读取资源失败");
            e.printStackTrace();
        }
        return properties;
    }
}
