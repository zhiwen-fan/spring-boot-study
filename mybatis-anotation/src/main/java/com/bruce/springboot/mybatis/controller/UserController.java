package com.bruce.springboot.mybatis.controller;

import com.bruce.springboot.mybatis.model.User;
import com.bruce.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bruce on 2018/9/6.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user/get")
    public User getUser() {
        return userService.selectById(1L);
    }
}
