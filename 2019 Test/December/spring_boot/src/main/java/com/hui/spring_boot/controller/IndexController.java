package com.hui.spring_boot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hui.spring_boot.entity.User;
import com.hui.spring_boot.mapper.UserMapper;
import freemarker.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/get")
    public User getOne(Integer id){
        User u = userMapper.selectById(id);
        return u;
    }

    @RequestMapping("/all")
    @ResponseBody
    public Object all(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapper.all();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
    @RequestMapping("/log")
    @ResponseBody
    public String log(String name){
        return "log4j";
    }
}
