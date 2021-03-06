package com.bruce.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by bruce on 2018/8/29.
 */
@EnableTransactionManagement
@SpringBootApplication
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class,args);
    }
}
