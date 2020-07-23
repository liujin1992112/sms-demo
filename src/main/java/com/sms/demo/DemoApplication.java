package com.sms.demo;

import com.sms.demo.listener.ApplicationStartListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.addListeners(new ApplicationStartListener());
        application.run(DemoApplication.class, args);
    }

}
