package com.bruce.redis;

import com.bruce.springboot.redis.Server;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Server.class)
@RunWith(SpringRunner.class)
public class SetValueTest {

    private static final String SET_KEY = "test:set";
    private static final String SET_KEY_2 = "test:set:2";
    private static final String SET_KEY_3 = "test:set:3";
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private SetOperations<String,String> setOperations;

    @Before
    public void before() {
        setOperations = redisTemplate.opsForSet();
    }

    //@After
    public void after() {
        redisTemplate.delete(SET_KEY);
        redisTemplate.delete(SET_KEY_2);
        redisTemplate.delete(SET_KEY_3);
    }

    @Test
    public void testAdd() {
        setOperations.add(SET_KEY, "AA");
        setOperations.add(SET_KEY, "BB");
        System.out.println(setOperations.members(SET_KEY));
        System.out.println(setOperations.add(SET_KEY,"AA"));
        System.out.println(setOperations.members(SET_KEY));
    }

    @Test
    public void testIsMember() {
        setOperations.add(SET_KEY,"AA");
        setOperations.add(SET_KEY,"BB");
        System.out.println(setOperations.isMember(SET_KEY,"AA"));
        System.out.println(setOperations.isMember(SET_KEY,"CC"));
    }

    @Test
    public void testIntersect() {
        setOperations.add(SET_KEY,"AA","BB","CC","DD","EE");
        setOperations.add(SET_KEY_2,"DD","EE","ff","gg");
        System.out.println(setOperations.intersect(SET_KEY, SET_KEY_2));

        setOperations.intersectAndStore(SET_KEY, SET_KEY_2, SET_KEY_3);
        System.out.println(setOperations.members(SET_KEY_3));
    }


    @Test
    public void testUnion() {
        setOperations.add(SET_KEY,"AA","BB","CC","DD","EE");
        setOperations.add(SET_KEY_2,"DD","EE","ff","gg");
        System.out.println(setOperations.union(SET_KEY,SET_KEY_2));
    }

    @Test
    public void testScan() {
        for (int i=0; i < 1000; i++) {
            setOperations.add(SET_KEY,"key" + i);
        }

        System.out.println("set count: " + setOperations.size(SET_KEY));

//        ScanOptions setOptions = ScanOptions.scanOptions().count(0).build();
//        Cursor<String> scan = setOperations.scan(SET_KEY, setOptions);
    }
}
