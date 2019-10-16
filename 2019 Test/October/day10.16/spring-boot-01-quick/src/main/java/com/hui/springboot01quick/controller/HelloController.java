package com.hui.springboot01quick.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("#{person.lastName}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return name+"你还";
    }
}
