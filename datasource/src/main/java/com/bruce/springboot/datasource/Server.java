package com.bruce.springboot.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;


/**
 * Created by bruce on 2019/1/31.
 */
@SpringBootApplication
public class Server {


    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(Server.class, args);
        final DataSource bean = context.getBean(DataSource.class);
        System.out.println(bean.toString());
        System.out.println("data source config:");
        User bean1 = context.getBean(User.class);
        System.out.println(bean1);

    }
}
