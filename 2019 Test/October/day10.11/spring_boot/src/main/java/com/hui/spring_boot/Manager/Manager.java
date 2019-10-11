package com.hui.spring_boot.Manager;

import java.sql.*;

public class Manager {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/spring";
    private static String username = "root";
    private static String password = "109742";
    public Connection getConnection(){
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
    public void closeResources(Connection conn,
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

    public void closeResources(Connection conn,
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
