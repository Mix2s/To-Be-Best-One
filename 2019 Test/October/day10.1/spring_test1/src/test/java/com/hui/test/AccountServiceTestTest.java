package com.hui.test;

import com.hui.domain.Account;
import com.hui.service.IAccountService;
import com.hui.spring.springConfigurtion;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfigurtion.class)
public class AccountServiceTestTest {
    @Autowired
    private IAccountService is = null;
    @Test
    public void testFindAll() {
        List<Account> accountList = is.findAllAccount();
        for(Account account:accountList){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

    }

    @Test
    public void testQueryRunner(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(springConfigurtion.class);
        QueryRunner r1 = ac.getBean("runner",QueryRunner.class);
        QueryRunner r2 = ac.getBean("runner",QueryRunner.class);
        System.out.println(r1==r2);
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