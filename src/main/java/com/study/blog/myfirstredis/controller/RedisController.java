package com.study.blog.myfirstredis.controller;

import com.study.blog.myfirstredis.config.RedisConfig;
import com.study.blog.myfirstredis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedisController {

    private RedisConfig redisConfig = new RedisConfig();
    private RedisService redisService = new RedisService(redisConfig.redisTemplate());

    @GetMapping("/redisTest")
    public String getUser(){
        redisService.practiceRedis();
        return "ok";
    }
}
