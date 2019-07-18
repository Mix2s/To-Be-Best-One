package test.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    工具类
 */
public class DataSourceUtils {
    //使用c3p0
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    //获取数据源 通过连接池对象
    public static DataSource getDataSorce(){
        return ds;
    }
    //获取连接对象
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn =  ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /*
       @param conn 释放连接资源
       @param stmt 释放执行对象
       @param rs   释放结果集
    */
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        closeConn(conn);
        closeStmt(stmt);
        closeRes(rs);
    }

    private static void closeRes(ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        rs = null;
    }

    private static void closeStmt(Statement stmt) {
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        stmt = null;
    }

    private static void closeConn(Connection conn) {
      if(conn!=null){
          try {
              conn.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      conn = null;
    }

}
