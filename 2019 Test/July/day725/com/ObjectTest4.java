package com;

import Person.SpringConfig;
import Person.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ObjectTest4 {
    private AnnotationConfigApplicationContext context;
    @Before
    public void testInitial(){
        context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
    @Test
    public void testMethod(){
        User user = (User)context.getBean("user");
        System.out.println(user.sayHello());
    }
}
