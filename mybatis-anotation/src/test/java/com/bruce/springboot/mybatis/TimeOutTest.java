package com.bruce.springboot.mybatis;

import com.bruce.springboot.mybatis.model.User;
import com.bruce.springboot.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Server.class)
public class TimeOutTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsert() {
        User user = new User(null,"bruce","password");
        userService.insert(user);
    }
}
