package com.hui.spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 配置类
 * Configuration
 * ComponentScan
 */
@Configuration
@ComponentScan(basePackages = "com.hui")
public class springConfigurtion {
    @Scope("prototype")
    @Bean("runner")
 public QueryRunner createQueryRunner(DataSource dataSource){
     /**
      * 创建queryRunner对象
      */
     return new QueryRunner(dataSource);
 }

@Bean(name="dataSource")
 public DataSource createDataSource(){
     ComboPooledDataSource ds = new ComboPooledDataSource();
     try {
         ds.setDriverClass("com.mysql.jdbc.Driver");
         ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy");
         ds.setUser("root");
         ds.setPassword("109742");
         return ds;
     } catch (PropertyVetoException e) {
          throw new RuntimeException(e);
     }
 }
}
