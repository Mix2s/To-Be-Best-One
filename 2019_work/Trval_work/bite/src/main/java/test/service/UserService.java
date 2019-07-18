package test.service;

import test.dao.UserDao;
import test.domain.User;

/**
 *  用户业务层
 */
public class UserService {
    public User login(String username, String password) {
        //调用dao查询用户
        UserDao dao = new UserDao();
        return dao.getUserByUserNameAndPassword(username,password);
    }
}
