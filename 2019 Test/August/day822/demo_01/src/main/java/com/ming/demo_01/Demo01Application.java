package com.ming.demo_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootConfiguration
 *          @Configuration: 代表的是这是一个spring的配置文件，类似applicationContext.xml
 * @EnableAutoConfiguration
 *          @AutoConfigurationPackage : 代表的是springboot会自动扫描启动类所在包，以及其子包
 *          @Import({AutoConfigurationImportSelector.class}) :代表springboot帮你自动导入了很多依赖关系
 * @ComponentScan : 扫描组件，将组件注入给spring容器
 */
//@ImportResource(locations="classpath:applicationContext-service.xml")
@SpringBootApplication
public class Demo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo01Application.class, args);
    }

}
