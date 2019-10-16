package com.hui.springboot01quick;

import com.hui.springboot01quick.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01QuickApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHello(){
        System.out.println(ioc.containsBean("helloService"));
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
