package com.hui.client.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.hui.utils.CommUtil;

import java.util.Properties;

public class BaseDao {
    private static DruidDataSource DATASOURCE;

    static {
        Properties properties = CommUtil.loadProperties("db.properties");
        try {
            DATASOURCE = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            DATASOURCE.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
