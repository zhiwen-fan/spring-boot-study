package com.bruce.springboot.mybatis.service.impl;

import com.bruce.springboot.mybatis.mapper.UserMapper;
import com.bruce.springboot.mybatis.model.User;
import com.bruce.springboot.mybatis.service.UserService;
import com.bruce.springboot.mybatis.util.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bruce on 2018/8/29.
 */
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
    @Transactional(timeout = 1)
    public int insert(User user){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = userMapper.insert(user);
        long cost = System.currentTimeMillis() - start;
        System.out.println("time cost: " + cost);
        return result;
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
