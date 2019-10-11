package com.hui.spring_boot.po;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@PropertySource(value = {"classpath:user.properties"})
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String userName;

    private int userAge;

    private boolean female;

    private List<Object> myLsit;

    private Map map;

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

    public List<Object> getMyLsit() {
        return myLsit;
    }

    public void setMyLsit(List<Object> myLsit) {
        this.myLsit = myLsit;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", female=" + female +
                ", myLsit=" + myLsit +
                ", map=" + map +
                '}';
    }
}
