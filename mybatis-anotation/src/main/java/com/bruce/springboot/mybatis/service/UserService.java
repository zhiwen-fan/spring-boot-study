package com.bruce.springboot.mybatis.service;

import com.bruce.springboot.mybatis.model.User;

import java.util.List;

/**
 * Created by bruce on 2018/8/29.
 */
public interface UserService {
    User selectById(Long id);

    List<User> selectAll();

    int insert(User user);

    int updateById(User user);

    int deleteById(Long id);
}
