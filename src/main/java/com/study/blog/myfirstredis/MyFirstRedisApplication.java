package com.study.blog.myfirstredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.study.blog.myfirstredis.config")
public class MyFirstRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstRedisApplication.class, args);
    }

}
