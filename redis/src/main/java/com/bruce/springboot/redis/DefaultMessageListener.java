package com.bruce.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

public class DefaultMessageListener implements MessageListener {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
        String msg = (String) redisTemplate.getValueSerializer().deserialize(body);
        String msgchannel = (String) redisTemplate.getValueSerializer().deserialize(channel);
        String msgPattern = new String(pattern);
        System.out.println("==>msg：" + msg + " ==>msgchannel：" + msgchannel + " ==>msgPattern：" + msgPattern);
    }
}
