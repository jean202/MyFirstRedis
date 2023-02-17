package com.study.blog.myfirstredis.controller;

import com.study.blog.myfirstredis.config.RedisConfig;
import com.study.blog.myfirstredis.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(
    onConstructor = @__(@Autowired)
)
public class RedisController {

    private final RedisConfig redisConfig;
    private final RedisService redisService;

    @GetMapping("redisTest")
    public String getUser(){
        redisService.practiceRedis();
        return "ok";
    }
}
