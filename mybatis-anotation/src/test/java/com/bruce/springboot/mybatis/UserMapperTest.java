package com.bruce.springboot.mybatis;

import com.bruce.springboot.mybatis.mybatis.Server;
import com.bruce.springboot.mybatis.mybatis.mapper.UserMapper;
import com.bruce.springboot.mybatis.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by bruce on 2018/8/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Server.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public  void testInsert() {
       for (int i = 0; i<3; i++) {
           User user = new  User(null,"bruce" +i,"pwd"+i);
           userMapper.insert(user);
           System.out.println(user.getId());
       }
    }

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(1L);
        System.out.println("user returned: " + user.toString());
    }

    @Test
    public void testUpdate() {
        User user = userMapper.selectById(1L);
        user.setName("update name");
        user.setPassword("update password");
        int result = userMapper.updateById(user);
        System.out.println("update num:" + result);
        System.out.println(userMapper.selectById(1l).toString());

    }

}
