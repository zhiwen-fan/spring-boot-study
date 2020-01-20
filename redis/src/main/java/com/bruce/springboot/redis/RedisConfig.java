package com.bruce.springboot.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by bruce on 2019/2/21.
 */
@Configuration
@EnableConfigurationProperties(value = RedisProperties.class)
public class RedisConfig {

    @Bean
    RedisConnectionFactory redisConnectionFactory(RedisProperties redisProperties) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(redisProperties.getHost());
        jedisConnectionFactory.setPassword(redisProperties.getPassword());
        jedisConnectionFactory.setPort(redisProperties.getPort());

        if(null != redisProperties.getPool()) {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(redisProperties.getPool().getMaxActive());
            jedisPoolConfig.setMaxWaitMillis(redisProperties.getPool().getMaxWait());
            jedisPoolConfig.setMaxIdle(redisProperties.getPool().getMaxIdle());
            jedisPoolConfig.setMinIdle(redisProperties.getPool().getMinIdle());
            jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        }

        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

   @Bean(value = "stringRedisTemplate")
    RedisTemplate<String,String> StringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        System.out.println("-------manual config redis template--");
        return redisTemplate;
    }
}
