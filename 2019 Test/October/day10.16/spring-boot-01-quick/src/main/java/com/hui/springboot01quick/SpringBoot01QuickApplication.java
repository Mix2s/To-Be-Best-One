package com.hui.springboot01quick;

import com.hui.springboot01quick.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = "classpath:beans.xml")
@SpringBootApplication
public class  SpringBoot01QuickApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01QuickApplication.class, args);

    }
}
