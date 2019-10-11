package com.hui.service;

import com.hui.dao.IAccountDao;
import com.hui.domain.Account;
import com.hui.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户业务接口实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService{
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }


    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //提交事务
            txManager.commit();
            //返回结果
            return accounts;
        }catch (Exception e){
            //回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            txManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            Account account = accountDao.findAccountById(accountId);
            //提交事务
            txManager.commit();
            //返回结果
            return account;
        }catch (Exception e){
            //回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            txManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.saveAccount(account);
            //提交事务
            txManager.commit();
        }catch (Exception e){
            //回滚操作
            txManager.rollback();
        }finally {
            //释放连接
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.updateAccount(account);
            //提交事务
            txManager.commit();
        }catch (Exception e){
            //回滚操作
            txManager.rollback();
        }finally {
            //释放连接
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.deleteAccount(accountId);
            //提交事务
            txManager.commit();
        }catch (Exception e){
            //回滚操作
            txManager.rollback();
        }finally {
            //释放连接
            txManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            //1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.根据名称查询装入账户
            Account target = accountDao.findAccountByName(targetName);
            //转出账户捡钱
            source.setMoney(source.getMoney()-money);
            //转入账户价钱
            target.setMoney(target.getMoney()+money);
            //更新装出账户
            accountDao.updateAccount(source);
            int i = 1/0;
            //更新转入账户
            accountDao.updateAccount(target);
            //提交事务
            txManager.commit();
        }catch (Exception e){
            //回滚操作
            txManager.rollback();
        }finally {
            //释放连接
            txManager.release();
        }
    }
}
