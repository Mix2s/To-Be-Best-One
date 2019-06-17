package com.bite;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 *  事件处理程序封装对象
 */
public class MyDefaultHandler3 extends DefaultHandler {
    //创建集合对象 List<List>
    private List<Contact> list = new ArrayList<Contact>();
    //定义一个方法 最终Contac内容List集合对象
    public List<Contact> getList(){
        return list;
    }

    private Contact contact = null;

    //记录当前读取的标签
    private String curTage;
    /**
     * 读取XML文件 遇到contact标签信息封装成Contact联系人对象
     * 将Conact对象添加到List集合中
     * 遍历输出Contact对象
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        curTage = qName;  //记录开始标签名称
            //当标签对象是contact标签的时候
        if (qName.equals("contact")) {
            //创建一个联系人对象
            contact = new Contact();
            String id = attributes.getValue("id");  //通过属性名称获取属性值
            //封装id属性
            contact.setId(id);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //将文本内容封装
        String content  = new String(ch,start,length);
        //遇到文本内容  空格与换行 会被解析
        if("name".equals(curTage)){   //"name".equals(curTage) 防止空指针
            contact.setName(content);
        }
        if("gender".equals(curTage)){
            contact.setGender(content);
        }
        if("phone".equals(curTage)){
            contact.setPhone(content);
        }
        if("email".equals(curTage)){
            contact.setEmail(content);
        }
        if("address".equals(curTage)){
            contact.setAddress(content);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //取出文本 空格 换行 curTage 清空
        curTage = null;
        //遇到结束标签
        if(qName.equals("contact")){
            //直接将Contact联系人对象 将contact添加list
            list.add(contact);
        }
    }
}
