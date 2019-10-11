package com.hui.factory;

import com.hui.domain.Account;
import com.hui.service.IAccountService;
import com.hui.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建Service代理对象工厂
 */
public class BeanFactory {

    private IAccountService accountService;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    private IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = null;
                        //添加事物的支持
                        try {
                            //开启事务
                            txManager.beginTransaction();
                            //执行操作
                            obj = method.invoke(accountService, args);
                            //提交事务
                            txManager.commit();
                            //返回结果
                            return obj;
                        } catch (Exception e) {
                            //回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
