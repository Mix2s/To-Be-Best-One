package com.bite;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 将xml contact 的信息封装成对象
 * 方式 dom4j
 */
public class Demo_xml {
    public static void main(String[] args) throws Exception {
        //目的将 contact.xml 变为 contact对象
        //xml--->List
        //1。读取xml文件
        Document reader = new SAXReader()
                .read(Demo_xml.class.getClassLoader()
                        .getResource("contact.xml"));
        //2.创建List集合 泛型指定 Contact
        List<Contact> conList  =  new ArrayList<>();
        //3.读取xml文件 根标签 elements（）;
         List<Element> eleList = reader.getRootElement().elements("contact");
            for(Element elem:eleList){
                //获取同名的contact标签对象
                Contact contact = new Contact();
                contact.setId(elem.attributeValue("id"));
                contact.setAddress(elem.elementText("address"));
                contact.setEmail(elem.elementText("email"));
                contact.setGender(elem.elementText("gender"));
                contact.setPhone(elem.elementText("phone"));
                contact.setName(elem.elementText("name"));
              //将contact添加到集合
                conList.add(contact);
            }
         //4.遍历3返回的List集合 获取每一个节点对象  封装Coontact对象setXXX
        for(Contact con:conList){
            System.out.println(con);
        }
    }
}
