package com.bite;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *  事件是处理程序
 */
public class MyDefaultHandler  extends DefaultHandler {
    //遇到开始文档

    @Override
    public void startDocument() throws SAXException {
        System.out.println("遇到开始文档");
    }
    //结束文档
    @Override
    public void endDocument() throws SAXException {
        System.out.println("触发结束文档");
    }
    //开始标签、
    //qName 开始标签名称
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("触发开始标签:"+qName);
    }

    // 结束标签
    //结束标签名称
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("结束标签名称:"+qName);
    }

    //文本内容

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //s 表示标签中实际的内容
        String s = new String(ch, start, length);
        System.out.println("触发文本内容:"+s);
    }
}
