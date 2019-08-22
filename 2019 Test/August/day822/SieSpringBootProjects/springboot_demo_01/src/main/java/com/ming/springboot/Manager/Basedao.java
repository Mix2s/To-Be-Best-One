package com.ming.springboot.Manager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Properties;


@Component
public class Basedao {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/spring";
    private static String username = "root";
    private static String password = "109742";
    protected Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
        return conn;
    }
    // 4.关闭资源
    protected void closeResources(Connection conn,
                                  Statement statement) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeResources(Connection conn,
                                  Statement statement,
                                  ResultSet resultSet) {
        closeResources(conn,statement);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
