package com.hui.service;

import com.hui.domain.Account;

/**
 * 账户业务层接口
 */
public interface IAccountService {
    Account findAccountById(Integer accountId);

    void transfer(String sourceName,String targetName,Float money);
}
