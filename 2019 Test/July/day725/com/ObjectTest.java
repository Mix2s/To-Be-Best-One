package com;


import Person.man;
import Person.women;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest {
    private ApplicationContext applicationContext  = null;
    @Before
    public void testInittal(){
        applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-beans.xml");
    }
    @Test
    public void testMethod(){
       man man = (man) applicationContext.getBean("man");
        women woman = (women)applicationContext.getBean("women");
        woman.dance("wudi");
    }
}
