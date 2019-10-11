package com.hui.dao;

import com.hui.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     */
    void saveAccount(Account account);

    /**
     * 更新操作
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 根据名称查询
     * @param accountName
     * @return 如果有唯一的结果就返回 如果没有结果返回null
     *
     */
    Account findAccountByName(String accountName);
}
