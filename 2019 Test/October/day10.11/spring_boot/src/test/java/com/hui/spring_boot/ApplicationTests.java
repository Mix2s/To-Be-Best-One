package com.hui.spring_boot;

import com.hui.spring_boot.po.User;
import com.hui.spring_boot.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private User user;

    @Autowired
    private UserServiceImpl userService;
    @Test
    public void contextLoads() {
        userService.addUser();
    }

    @Test
    public void selectUser(){
        userService.selectUser();
    }

}
