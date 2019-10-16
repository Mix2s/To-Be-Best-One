package com.hui.dao;

import com.hui.domain.Account;

/**
 * 账户持久层接口
 */
public interface IAccountDao {

    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void findAccount(Account account);

    void updateAccount(Account account);
}
