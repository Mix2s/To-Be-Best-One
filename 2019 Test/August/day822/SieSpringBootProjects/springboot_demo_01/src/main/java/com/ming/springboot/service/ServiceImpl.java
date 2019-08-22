package com.ming.springboot.service;

import com.ming.springboot.dao.daoImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl {


    @Autowired
    private daoImpl dao;

    @Test
    public void selectAll() {
         dao.selectAll();
    }
}
