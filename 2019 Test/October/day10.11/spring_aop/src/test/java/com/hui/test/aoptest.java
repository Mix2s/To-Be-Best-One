package com.hui.test;

import com.hui.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class aoptest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
    }
}
