package com.sms.demo;

import com.sms.demo.listener.ApplicationStartListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 1、注意多个不同类型的application配置文件时，需要通过Edit Configuration --> Environments variables --> spring.profiles.active = dev/test/prod决定配置文件
 * 2、springboot整合tk.mybatis时需要将注解修改为tk.mybatis.spring.annotation.MapperScan,不能使用org.mybatis.spring.annotation.MapperScan注解
 * 3、swagger2的文档入口http://localhost:8080/swagger-ui.html
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.sms.demo.mapper.*")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.addListeners(new ApplicationStartListener());
        application.run(DemoApplication.class, args);
    }

}
