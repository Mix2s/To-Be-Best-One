package com.hui.springbootjpa.listener;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.stereotype.Component;


public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
    public HelloSpringApplicationRunListener(SpringApplication application,String[] args){

    }

    @Override
    public void starting(){
        System.out.println("SpringApplication  启动开始");
    }
}
