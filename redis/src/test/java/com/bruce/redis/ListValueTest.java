package com.bruce.redis;

import com.bruce.springboot.redis.Server;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest(classes = Server.class)
@RunWith(SpringRunner.class)
public class ListValueTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private ListOperations<String, String> listOperations;

    @Before
    public void setListOperations() {
        listOperations = redisTemplate.opsForList();
    }

    @Test
    public void testPush() {
        listOperations.leftPush("test:list", "a");
        listOperations.leftPush("test:list","b");

        listOperations.leftPushAll("test:list", Arrays.asList(new String[]{"c","d"}));

        Long size = listOperations.size("test:list");
        Assert.assertEquals(4,size.longValue());
        redisTemplate.delete("test:list");
    }

    @Test
    public void testPop() {
        listOperations.leftPushAll("test:list", Arrays.asList(new String[]{"c","d","a","b","e"}));
        String result = listOperations.leftPop("test:list");
        Assert.assertEquals("e",result);

        result = listOperations.rightPop("test:list");
        Assert.assertEquals("c",result);
        del();
    }

    @Test
    public void testTrim() {
        listOperations.leftPushAll("test:list", Arrays.asList(new String[]{"c","d","a","b","e"}));
        System.out.println(listOperations.range("test:list",0,-1));
        listOperations.trim("test:list",2,5);
        System.out.println(listOperations.range("test:list",0,-1));
        del();
    }


    @Test
    public void testDeleteBigKey() {
        insertData();
        //delete direct
        long start = System.currentTimeMillis();
        redisTemplate.delete("test:list");
        long end = System.currentTimeMillis();
        System.out.println("cost time when direct delete: " + (end - start));

    }

    @Test
    public void testDeleteBigKeyWithTrim() {
        insertData();
        long startTime = System.currentTimeMillis();
        Long size = listOperations.size("test:list");
        long counter = 0;
        long left = 1000;
        while (counter < size) {
            long start = System.currentTimeMillis();
            listOperations.trim("test:list",left,size);
            long end = System.currentTimeMillis();
            counter +=left;
            System.out.println(end - start);
        }
        redisTemplate.delete("test:list");
        long endTime = System.currentTimeMillis();
        System.out.println("total cost time: " + (endTime - startTime));
    }


    @Test
    public void testSize() {
        Long size = listOperations.size("test:list");
        System.out.println(size);
    }

    @Test
    public void insertData() {
        long start = System.currentTimeMillis();
        for (int i = 1; i< 10000; i++) {
            listOperations.leftPushAll("test:list", Arrays.asList(new String[]{"a","b","b","d","e","e","4","a","b","b","d","e","e","4"}));
        }
        long end = System.currentTimeMillis();
        System.out.println("insert data cost time: " + (end - start));
    }
    @Test
    public void del() {
        redisTemplate.delete("test:list");
    }
}
