package com.hui.springbootjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruilConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druild(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean stateViewServlet(){
       ServletRegistrationBean bean =  new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
       Map<String,String> initParams = new HashMap<>();
       initParams.put("loginUsername","admin");
       initParams.put("loginPassword","123456");
       initParams.put("allow","");
       bean.setInitParameters(initParams);
       return bean;
    }

    @Bean
    public FilterRegistrationBean webStateFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
