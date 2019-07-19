package com.bruce.mybatis.xml;

import com.bruce.mybatis.xml.mapper.UserMapper;
import com.bruce.mybatis.xml.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Server.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("fan xml test");
        user.setPassword("password");
        int result = userMapper.insert(user);
        Assert.assertEquals(1,result);
    }

    @Test
    public void testSelect() {
        User user = userMapper.selectById(10L);
        Assert.assertEquals(10,user.getId().longValue());
    }
}
