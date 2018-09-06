package com.bruce.springboot.mybatis.mybatis.service.impl;

import com.bruce.springboot.mybatis.mybatis.mapper.UserMapper;
import com.bruce.springboot.mybatis.mybatis.model.User;
import com.bruce.springboot.mybatis.mybatis.service.UserService;
import com.bruce.springboot.mybatis.mybatis.util.UtilService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bruce on 2018/8/29.
 */
@Lazy()
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UtilService utilService;

    User selectById(Long id) {
        return userMapper.selectById(id);
    }

    List<User> selectAll() {
        return userMapper.selectAll();
    }


    int insert(User user) {
        return userMapper.insert(user);
    }

    int updateById(User user) {
        return userMapper.updateById(user);
    }

    int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

}
