package com.bruce.springboot.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.Arrays;

@Configuration
public class RedisSubscribeConfig {

    @Bean
    DefaultMessageListener defaultMessageListener() {
        return new DefaultMessageListener();
    }

    @Bean
    SecondMessageListener secondMessageListener() {
        return new SecondMessageListener();
    }
    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(JedisConnectionFactory redisConnectionFactory,
        DefaultMessageListener defaultMessageListener,
        SecondMessageListener secondMessageListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        ChannelTopic defaultTopic = new ChannelTopic("defaultTopic");
        ChannelTopic secondTopic = new ChannelTopic("secondTopic");
        container.addMessageListener(defaultMessageListener, Arrays.asList(defaultTopic));
        container.addMessageListener(secondMessageListener,Arrays.asList(secondTopic));
        return container;
    }
}
