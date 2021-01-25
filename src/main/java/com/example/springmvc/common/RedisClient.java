package com.example.springmvc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

@Configuration
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Bean
    public ValueOperations<String, Object> valueOperations() {
        return redisTemplate.opsForValue();
    }

    @Bean
    public SetOperations<String, Object> setOperations() {
        return redisTemplate.opsForSet();
    }
}
