package com.bruce.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by bruce on 2019/2/21.
 */
@SpringBootApplication
public class Server {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Server.class, args);
        RedisRepository redisRepository = applicationContext.getBean(RedisRepository.class);
        redisRepository.set("redis:testKey","testValue");
        System.out.println(redisRepository.get("redis:testKey"));
    }
}
