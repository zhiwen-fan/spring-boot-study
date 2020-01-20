package com.bruce.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class PublishServer {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PublishServer.class,args);
    }


    @RequestMapping(value = "/redis/sendMessage")
    public String sendMessage(String channel, String message) {
        redisTemplate.convertAndSend(channel,message);
        return "success";
    }
}
