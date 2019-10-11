package com.hui.spring_boot.dao;

import com.hui.spring_boot.Manager.Manager;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class daoImpl implements Idao{
    private static Connection conn = null;
   static {
       Manager manager = new Manager();
       conn =manager.getConnection();
   }


    @Override
    public void selectAll() {
        PreparedStatement  preparedStatement= null;
        ResultSet resultSet = null;
        String sql  = "select * from user";
        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet!=null){
                System.out.println("成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
