package cn.bite.travel.service;

import cn.bite.travel.domain.User;

/**
 * 用户相关业务接口层
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean regist(User user);

    /**
     * 邮件激活
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 根据前台返回的用户名密码查询
     * @param user
     * @return
     */
    User findByUsernameAndPassword(User user);
}
