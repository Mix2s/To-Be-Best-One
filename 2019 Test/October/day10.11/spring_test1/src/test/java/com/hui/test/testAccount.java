package com.hui.test;

import com.hui.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class testAccount {

    @Autowired
    @Qualifier("proxyAccountSetvice")
    private IAccountService as;

    @Test
    public void transfer() {
        as.transfer("aaa","bbb",100f);
    }
}
