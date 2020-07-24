package com.sms.demo;

import com.sms.demo.listener.ApplicationStartListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 通过Edit Configuration --> Environments variables --> spring.profiles.active = dev/test/prod决定配置文件
 */
@SpringBootApplication
@MapperScan(basePackages = "com.sms.demo.mapper.*")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.addListeners(new ApplicationStartListener());
        application.run(DemoApplication.class, args);
    }

}
