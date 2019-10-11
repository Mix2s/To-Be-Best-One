package com.hui.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 从数据源获取一个连接实现线程绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取线程连接
     * @return
     */
    public Connection getThreadConnection(){
        //获取线程连接
        Connection conn = t1.get();
        //判断线程上是否有连接
        if(conn==null){
            //从数据源获取连接并且存入
            try {
                conn = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            t1.set(conn);
        }
        //返回当前线程连接
        return conn;
    }

    /**
     * 将连接与线程解绑
     */
    public void removeConnection(){
            t1.remove();
    }
}
