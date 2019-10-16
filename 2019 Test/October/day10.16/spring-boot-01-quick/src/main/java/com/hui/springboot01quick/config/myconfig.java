package com.hui.springboot01quick.config;

import com.hui.springboot01quick.service.helloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myconfig {
    @Bean
    public helloService helloService(){
        return new helloService();
    }
}
