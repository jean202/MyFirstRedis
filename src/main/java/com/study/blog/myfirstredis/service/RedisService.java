package com.study.blog.myfirstredis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisService {


    private final RedisTemplate<String, String> redisTemplate;
    public void practiceRedis() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String refreshToken = "token";
        String refreshTokenKey = "rtKey";
        valueOperations.set(refreshTokenKey, refreshToken);
        String value = valueOperations.get(refreshTokenKey);
        log.info("redis RefreshTokenKey : {}", valueOperations.get(refreshTokenKey));
        log.info("redis getValue: {}", value);
    }

}
