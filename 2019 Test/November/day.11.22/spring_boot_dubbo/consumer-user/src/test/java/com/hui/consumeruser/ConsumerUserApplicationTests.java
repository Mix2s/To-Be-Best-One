package com.hui.consumeruser;

import com.hui.consumeruser.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerUserApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.heello();
    }

}
