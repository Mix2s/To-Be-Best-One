package com.bite;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *  将 contact文件原模原样打印
 */
public class SAX_Text {
    public static void main(String[] args) throws Exception {
        // SAX解析器对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        //创建事件处理程序对象
        MyDefaultHandler2 dh2 = new MyDefaultHandler2();
        // 解析读取contact.xml
        parser.parse(SAX_Text.class.getClassLoader().getResourceAsStream("contact.xml"),dh2);
        System.out.println(dh2.getContent());
    }
}
