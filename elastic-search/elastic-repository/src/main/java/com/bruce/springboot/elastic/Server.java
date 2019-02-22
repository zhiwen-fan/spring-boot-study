package com.bruce.springboot.elastic;

import com.bruce.springboot.elastic.domain.Address;
import com.bruce.springboot.elastic.domain.User;
import com.bruce.springboot.elastic.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.List;

/**
 * Created by bruce on 2019/2/22.
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.bruce.springboot.elastic.repository")
public class Server {

    private static UserService userService;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Server.class, args);
        userService = applicationContext.getBean(UserService.class);


       //index();
       query();
    }

    static void index() {
        User user = new User();
        user.setId(1L);
        user.setName("bruce fan");
        user.setAge(30);
        user.setEmail("bruce@weimob.com");
        user.setSex("male");
        user.setAddress(new Address("anhui","xuancheng","nanhu"));
        userService.index(user);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("zhiwen fan");
        user2.setAge(20);
        user2.setEmail("zhiwen@weimob.com");
        user2.setSex("male");
        user2.setAddress(new Address("anhui","hefei","gaoxin"));
        userService.index(user2);
    }

    static void query() {
        User user = userService.findById(1L);
        System.out.println(user.toString());

        List<User> userList = userService.findByProvince("anhui");
        System.out.println(userList.size());

        List<User> byName = userService.findByName("fan");
        System.out.println("byName result size: " + byName.size());
    }
}
