package com.shuaihui;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/*class Option{
    *//**
     * 配置选项
     *//*
}*/


public class CaseLoader {

    public CaseRunner load(){
        String pkg = "com/shuaihui/cases";
        String pkgDot = "com.shuaihui.cases";

        List<String> classNameList = new ArrayList<String>();

        //拿到类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        //使用类加载器拿到路径
        Enumeration<URL> urls = null;
        try {
           urls = classLoader.getResources(pkg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            if(!url.getProtocol().equals("file")){
                //不能加载*.class
                continue;
            }

            String dirname = null;
            try {
                dirname = URLDecoder.decode(url.getPath(),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            File dir = new File(dirname);
            if(!dir.isDirectory()){
                continue;
            }

            //扫描目录下所有的*.class
            File[] files = dir.listFiles();
            if(files==null){
                continue;
            }

            for(File file:files){
                //TDDD 没有解决 后缀不是。class

                String filename = file.getName();
                String className = filename.substring(0,filename.length()-6);
                classNameList.add(className);
            }
        }

        List<Case> caseList = new ArrayList<Case>();
        for(String classNmae:classNameList){
            Class<?> cls  = null;
            try {
                cls = Class.forName(pkgDot+"."+classNmae);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if(hasInterface(cls,Case.class)){
                try {
                    caseList.add((Case)cls.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        //扫描所有的类文件

        return new CaseRunner(caseList);
    }

    private boolean hasInterface(Class<?> cls, Class<?> intf) {
        Class<?>[] intfs = cls.getInterfaces();
        for(Class<?> i:intfs){
            if(i==intf){
                return true;
            }
        }
        return false;
    }
}
