package cn.bite.travel.dao;

import cn.bite.travel.domain.User;

/**
 * 用户相关数据库访问接口层
 */
public interface UserDao {
    /*
        根据用户名查询用户
     */
    public User finByUsername(String username);

    /**
     * 保存
     */
    public void saveUser(User user);


    /**
     * 查询用户code
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 更新用户激活状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据登录页面账户密码查询
     * @param username
     * @param password
     * @return
     */
    User finByUsernameAndPassword(String username, String password);
}
