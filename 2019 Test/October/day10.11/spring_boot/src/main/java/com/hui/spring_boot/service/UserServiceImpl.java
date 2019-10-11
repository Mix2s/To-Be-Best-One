package com.hui.spring_boot.service;

import com.hui.spring_boot.dao.daoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private daoImpl dao;

    @Override
    public void addUser() {
        System.out.println("添加成功");
    }

    @Override
    public void selectUser() {
            dao.selectAll();
    }
}
