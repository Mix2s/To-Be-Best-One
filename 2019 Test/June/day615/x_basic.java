package com.bite;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;

/*
    将一个xml文件写到硬盘上
 */
public class write_xml {
    public static void main(String[] args) throws Exception {
        //获取Document 解析器对象
        Document document = new SAXReader()
                .read(write_xml.class.getClassLoader()
                        .getResource("contact.xml"));
        //将文档对象输出到硬盘
        //XMLWriter(OutputStream)
        OutputStream out = new FileOutputStream("D:/xml.xml");
        //指定输出细节 OutputFormat
        //OutputFormat compactFormat = OutputFormat.createCompactFormat();//xml变为紧凑格式
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();        //xml变温优雅格式

        //指定输出到硬盘的编码格式
        prettyPrint.setEncoding("GBK");
        XMLWriter writer = new XMLWriter(out,prettyPrint);
        //将指定document写到指定磁盘中
        writer.write(document);
        //释放资源
        writer.close();
    }
}
