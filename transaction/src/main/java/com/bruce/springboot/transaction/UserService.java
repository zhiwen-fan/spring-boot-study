package com.bruce.springboot.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bruce on 2019/2/20.
 */
@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(timeout = 1)
    public void insert() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update("INSERT INTO user(name, password) VALUE (?,?)",new Object[]{"testName","testPassword"});
         long cost = System.currentTimeMillis() - start;
         System.out.println("cost time: " + cost);
    }
}
