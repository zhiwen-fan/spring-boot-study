package com.bruce.springboot.mybatis.service.impl;

import com.bruce.springboot.mybatis.mapper.UserMapper;
import com.bruce.springboot.mybatis.model.User;
import com.bruce.springboot.mybatis.service.UserService;
import com.bruce.springboot.mybatis.util.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bruce on 2018/8/29.
 */
@Lazy()
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UtilService utilService;

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }
    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

}
