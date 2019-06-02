package com.hui;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class demo1 {
    public static void main(String[] args) throws Exception{
        Document doc = new SAXReader().read(demo1.class.getClassLoader().getResource("contact.xml"));
        List<Contact> conList = new ArrayList<>();
        List<Element> elemList = doc.getRootElement().elements("contact");
        for(Element elem:elemList){
            Contact contact = new Contact();
            contact.setId(elem.attributeValue("id"));
            contact.setAddress(elem.elementText("address"));
            contact.setName(elem.elementText("name"));
            contact.setEmail(elem.elementText("email"));
            contact.setPhone(elem.elementText("phone"));

            conList.add(contact);
        }
        for(Contact contact:conList){
            System.out.println(contact);
        }
    }
    public static void code1() throws Exception{
        SAXReader reader = new SAXReader();
        Document doc  = reader.read(demo1.class.getClassLoader().getResource("contact.xml"));
        Element con = doc.getRootElement().element("contact");
        String idAtr = con.attributeValue("id");
        Attribute attr = con.attribute("id");
        System.out.println(attr.getName()+"="+attr.getValue());

//        String rootText = doc.getRootElement().getText();
//        System.out.println(rootText);
        Element nameElem = doc.getRootElement().element("contact").element("name");
        System.out.println(nameElem.getText());
        con = doc.getRootElement().element("contact");
        String address = con.elementText("address");
        System.out.println(address);
        SAXReader reader1 = new SAXReader();
        Document doc1  = reader.read(demo1.class.getClassLoader().getResource("contact.xml"));
        Element rootElem = doc.getRootElement();
        Element conElem = rootElem.element("contact");
        List<Element> list = rootElem.elements("contact");
        Iterator<Element> it = list.iterator();
        while(it.hasNext()){
            Element next = it.next();
            System.out.println(next);
        }
        List<Element> elements = rootElem.elements();
        for(Element element:elements){
            System.out.println(element);
        }
    }
}
