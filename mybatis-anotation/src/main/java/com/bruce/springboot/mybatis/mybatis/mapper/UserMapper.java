package com.bruce.springboot.mybatis.mybatis.mapper;

import com.bruce.springboot.mybatis.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by bruce on 2018/8/29.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })
    User selectById(Long id);
    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })
    List<User> selectAll();


    @Insert("insert into user(name,password) values (#{name},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(User user);

    @Update("update user set name=#{name},password=#{password} where id = #{id}")
    int updateById(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(Long id);
}
