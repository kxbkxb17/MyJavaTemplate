package com.kxb.myjavatemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MyJavaTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyJavaTemplateApplication.class, args);
    }

}
