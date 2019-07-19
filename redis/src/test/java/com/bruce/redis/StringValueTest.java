package com.bruce.redis;

import com.bruce.springboot.redis.Server;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = {Server.class})
@RunWith(SpringRunner.class)
public class StringValueTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("test:name","test value");
        String value = redisTemplate.opsForValue().get("test:name");
        Assert.assertEquals("test value",value);
    }

    @Test
    public void testExpire() throws InterruptedException {
        redisTemplate.opsForValue().set("test:name:expire","test value expire",1, TimeUnit.SECONDS);
        String value = redisTemplate.opsForValue().get("test:name:expire");
        Assert.assertEquals("test value expire",value);
        Thread.sleep(2000);
        value = redisTemplate.opsForValue().get("test:name:expire");
        Assert.assertEquals(null,value);
        del("test:name:expire");
    }

    @Test
    public void testIncrement() {
        del("test:increment");
        Long increment = redisTemplate.opsForValue().increment("test:increment", 1L);
        Assert.assertEquals(1,increment.longValue());
        increment = redisTemplate.opsForValue().increment("test:increment", 3L);
        Assert.assertEquals(4,increment.longValue());

        expire("test:increment",5L);
        Long expire = redisTemplate.getExpire("test:increment");
        System.out.println(expire);
    }

    @Test
    public void testSetNx() {
        Boolean result = redisTemplate.opsForValue().setIfAbsent("test:setnx", "test");
        Assert.assertTrue("set if absent success",result);
        result = redisTemplate.opsForValue().setIfAbsent("test:setnx", "test");
        Assert.assertFalse("set if absent fail",result);
        expire("test:setnx",6L);
        System.out.println(redisTemplate.getExpire("test:setnx"));
    }

    public void del(String key) {
        redisTemplate.delete(key);
    }

    public void expire(String key,Long time) {
        redisTemplate.expire(key,time,TimeUnit.SECONDS);
    }
}
