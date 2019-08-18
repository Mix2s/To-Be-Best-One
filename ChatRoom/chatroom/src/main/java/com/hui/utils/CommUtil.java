package com.hui.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommUtil {
    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        InputStream in = CommUtil.class.getClassLoader().getResourceAsStream(fileName);

        try {
            properties.load(in);
        } catch (IOException e) {
            System.out.println("加载文件信息出错");
            e.printStackTrace();
            return null;
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
