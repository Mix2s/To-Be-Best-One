package com.hui.eurekaserver_12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer12Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer12Application.class, args);
    }

}
