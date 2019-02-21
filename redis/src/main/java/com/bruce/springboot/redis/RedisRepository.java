package com.bruce.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by bruce on 2019/2/21.
 */
@Component
public class RedisRepository {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
