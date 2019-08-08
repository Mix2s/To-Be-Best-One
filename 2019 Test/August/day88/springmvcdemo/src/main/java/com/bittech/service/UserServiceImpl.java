package com.bittech.service;

import com.bittech.dao.UserDao;
import com.bittech.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUserService() throws Exception {
        //call by DAO layer
        return userDao.queryUserDAO();
    }
}

