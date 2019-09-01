package com.hui.client.service;

import com.hui.utils.CommUtil;
import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;

public class Connect2Server {
    /**
     * 封装客服端与服务端建立的连接以及输入输出流
     */
   private static final int PORT;
   private static final String IP;
   private Socket client;
   private InputStream in;
   private OutputStream out;
   static{
       Properties pros = CommUtil.loadProperties("socket.properties");
       PORT = Integer.parseInt(pros.getProperty("PORT"));
       IP = pros.getProperty("IP");
   }
   public Connect2Server(){
       try{
           client = new Socket(IP,PORT);
           this.in = client.getInputStream();
           this.out = client.getOutputStream();
       }catch (IOException e){
           e.printStackTrace();
       }
   }

   public InputStream getIn(){
       return in;
   }
   public OutputStream getOut(){
       return out;
   }
}
