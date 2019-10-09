package com.hui.test;

import com.hui.domain.Account;
import com.hui.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class AccountServiceTestTest {

    @Test
    public void testFindAll() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //得到业务对象
        IAccountService is = ac.getBean("accountService",IAccountService.class);
        //执行方法
        List<Account> accountList = is.findAllAccount();
        for(Account account:accountList){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

    }

    @Test
    public void testSave() {
        Account account  = new Account();
        account.setName("ddd");
        account.setMoney(10000f);
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //得到业务对象
        IAccountService is = ac.getBean("accountService",IAccountService.class);
        //执行方法
        is.saveAccount(account);
    }

    @Test
    public void testUpdae() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //得到业务对象
        IAccountService is = ac.getBean("accountService",IAccountService.class);
        //执行方法
        Account account = is.findAccountById(4);
        account.setMoney(999f);
        is.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //得到业务对象
        IAccountService is = ac.getBean("accountService",IAccountService.class);
        //执行方法
       is.deleteAccount(4);

    }

}