package com.hui.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommUtil {
    private static final Gson GSON = new GsonBuilder().create();
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
    public static String object2Json(Object obj){
        return GSON.toJson(obj);
    }
    public static Object json2Object(String jsonStr,Class objClz){
        return GSON.fromJson(jsonStr,objClz);
    }
}
