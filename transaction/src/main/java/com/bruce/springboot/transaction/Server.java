package com.bruce.springboot.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by bruce on 2019/2/20.
 */
@EnableTransactionManagement
@SpringBootApplication
public class Server {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Server.class, args);
        PlatformTransactionManager transactionManager = applicationContext.getBean(PlatformTransactionManager.class);
        System.out.println(transactionManager.getClass().getName());
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insert();
    }
}
