package com.bruce.mybatis.xml.mapper;

import com.bruce.mybatis.xml.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    User selectById(Long id);

    List<User> selectAll();
}
