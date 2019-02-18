package com.bruce.springboot.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 * Created by bruce on 2019/1/31.
 */
@Service
public class SqlTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User selectUser() {
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);

        return jdbcTemplate.queryForObject("select * from user where id = 1", rowMapper);
    }
}
