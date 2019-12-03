package com.hui.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String addUser(int id,String name){
        jdbcTemplate.update("insert into user values (?,?)",id,name);
        return "success";
    }
}
