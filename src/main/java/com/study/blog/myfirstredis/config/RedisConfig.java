package com.study.blog.myfirstredis.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@RequiredArgsConstructor
@Configuration
@Slf4j
//@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        log.info("came here?");
        log.info("host : {}", host);
        log.info("port: {}", port);
        return new LettuceConnectionFactory(host, port);
    }

    // RedisConnectionFactory 인터페이스를 통해 LettuceConnectionFactory를 생성하여 반환
    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        // Spring - Redis 간 데이터 직렬화, 역직렬화 시 사용하는 방식이 Jdk 직렬화 방식
        // redis-cli을 통해 직접 데이터를 보려고 할 때 알아보기 위해 설정
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
