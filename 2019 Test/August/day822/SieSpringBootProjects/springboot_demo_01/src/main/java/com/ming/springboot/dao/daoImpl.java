package com.ming.springboot.dao;

import com.ming.springboot.Manager.Basedao;
import com.ming.springboot.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Component
public class daoImpl extends Basedao implements Idao{
    @Autowired
    private Basedao basedao;

    @Override
    public void selectAll() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = null;
        try{
            conn = getConnection();
            String sql = "select * from user";
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setuName(resultSet.getString("username"));
                System.out.println(user);
            }
        }catch(Exception e){
            System.out.println("连接失败");
            e.printStackTrace();
        }finally {
            closeResources(conn,preparedStatement);
        }
    }
}
