package com.hui;

import com.hui.dao.IAccountDao;
import com.hui.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class testAccount {
    @Autowired
    private IAccountService as;
    @Test
    public void testTran(){
        as.transfer("aaa","bbb",100f);
    }
}
