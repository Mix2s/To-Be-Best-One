package com.ming.demo_01.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: xiao ming
 * @create:2019-08-2019/8/22 10:47
 */

/***
 * 【applicationContext.xml】
 * <bean id="user" class="com.ming.po.User">
 *      <property name="userName" value="zhangsan"/>
 * </bean>
 *
 * application.yml
 */

//@PropertySource : 进行分文件管理，是springboot识别PropertySource中value指定的文件,只能引入后缀为.properties的文件
//By default the @PropertySource annotation isn’t usable with YAML files.
@PropertySource(value={"classpath:user.properties"})
@Component
//@ConfigurationProperties(prefix = "user")
public class User {

    //@Value("${}"):读取的是properties文件的值
    @Value("${abc.def}")
    private String userName;

    @Value("#{10*20}")//SpEL
    private int userAge;

    private boolean female;

    private List<Object> myList;

    private Map map;

    private Orders orders;

    public User(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

//    public List getMyList() {
//        return myList;
//    }
//
//    public void setMyList(List myList) {
//        this.myList = myList;
//    }


    public List<Object> getMyList() {
        return myList;
    }

    public void setMyList(List<Object> myList) {
        this.myList = myList;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", female=" + female +
                ", myList=" + myList +
                ", map=" + map +
                ", orders=" + orders +
                '}';
    }
}
