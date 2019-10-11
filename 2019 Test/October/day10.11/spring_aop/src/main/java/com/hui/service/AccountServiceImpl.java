package com.hui.service;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService{

    @Override
    public void saveAccount() {
        System.out.println("执行saveAccount");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行updateAccount");
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行deleteAccount");
        return 0;
    }
}
