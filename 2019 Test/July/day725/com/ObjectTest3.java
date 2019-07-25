package com;


import bean.Bean1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest3 {
    private ApplicationContext applicationContext  = null;
    @Before
    public void testInittal(){
        applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext-beans.xml","applicationContext-beans2.xml"});
    }
    @Test
    public void testMethod(){
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println("strValue  = "+bean1.getStrValue());
        System.out.println("intValue  = " + bean1.getIntValue());
        System.out.println("mapValue = "+bean1.getMapValue());
    }
}
