package com.ming.demo_01;

import com.ming.demo_01.po.Orders;
import com.ming.demo_01.po.User;
import com.ming.demo_01.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01ApplicationTests {

    /**
     * ApplicationContext context = new ClassPathXMLApplicationContext("applicationContextr.xml");
     * User user = (User) context.getBean("user")
     */

    @Autowired
    private ApplicationContext context;

    @Autowired
    private User user;

    @Autowired
    private Orders orders;

    @Test
    public void contextLoadsUser() {
        System.out.println(user);
    }

    @Test
    public void contextLoadsOrder() {
        System.out.println(orders);
    }

    @Test
    public void testService() {
        UserService userService = (UserService) context.getBean("userServiceImpl2");
        userService.addUser();
    }


}
