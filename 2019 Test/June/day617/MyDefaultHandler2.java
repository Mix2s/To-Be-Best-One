package com.bite;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler2 extends DefaultHandler {
    //构建字符串访问区对象
    private StringBuffer sb = new StringBuffer();
    //定义一个 获取文本内容输出方法
    public String getContent(){
        return sb.toString();
    }

    // qName 开始标签名称
    // attributes 属性列表
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //拼接开始标签
        sb.append("<"+qName);
        //获取每一个属性对象 attribute
        for(int i=0;i<attributes.getLength();i++){
            //获取属性 名称 以及值
            String  value= attributes.getValue("id");  //属性值
            String name = attributes.getQName(i);
            //拼接属性<contact id="001">
            sb.append(" "+name+"=\""+value+"\"");
        }
        sb.append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //获取当前名称中的文本内容
        String contact = new String(ch,start,length);
        sb.append(contact);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       sb.append("<"+qName+">");
    }
}
