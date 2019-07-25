package com;


import Person.man;
import Person.women;
import bean.Bean2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest2 {
    private ApplicationContext applicationContext  = null;
    @Before
    public void testInittal(){
        applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext-beans.xml","applicationContext-beans3.xml"});
    }
    @Test
    public void testMethod(){
        Bean2 bean2 = (Bean2)applicationContext.getBean("bean2");
        System.out.println("============bean3=============");
        System.out.println(bean2.getBean3().getId());
        System.out.println(bean2.getBean3().getUsername());
        System.out.println("============bean4===============");
        System.out.println(bean2.getBean4().getId());
        System.out.println(bean2.getBean4().getUsername());
        System.out.println("==============bean5==============");
        System.out.println(bean2.getBean5().getAge());
    }

}
