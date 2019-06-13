package com.bite;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/*
    读取xml文件
        添加相关
            1.创建空文档
             2.添加根标签 属性

     读取xml文件
        编辑xml文件
            1.修改标签属性
            2.修改文本内容
        删除
            1.删除标签属性
            2.删除指定标签
 */
public class print_xml {
    public static void main(String[] args) throws Exception {
        Document doc = UpdateDocument();
        OutputStream out = new FileOutputStream("e:/contact.xml");
      OutputFormat format = OutputFormat.createPrettyPrint();
      XMLWriter writer = new XMLWriter(out,format);
      writer.write(doc);
      writer.close();
    }

    private static Document UpdateDocument() throws DocumentException {
        //修改文件
        //1读取resource下contact.xml文件
        Document doc = new SAXReader().read(print_xml.class.getClassLoader().getResource("contact.xml"));
        //2.修改标签属性
        Element conElem = doc.getRootElement().element("contact");
        //通过标签对象获取属性
        Attribute idAttr = conElem.attribute("id");
        //setVale更改属性值
        idAttr.setValue("003");
        return doc;
    }

    private static Document addDoc() {
        //添加相关
        //创建空文档DocumentHelper.createDocument();
        Document doc = DocumentHelper.createDocument();
        //通过文档对象 添加根节点
        Element rootElem = doc.addElement("Element-list");
        //根节点添加属性
        rootElem.addAttribute("id","001");
        rootElem.addAttribute("name","帅");
        //添加子节点
        Element conEle = rootElem.addElement("contact");
        Element name = conEle.addElement("name");
        return doc;
    }
}
