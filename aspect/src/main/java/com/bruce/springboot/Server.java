package com.bruce.springboot;

import com.bruce.springboot.bean.CrudBean;
import com.bruce.springboot.service.CrudService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by bruce on 2019/1/31.
 */
@SpringBootApplication
public class Server {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Server.class, args);
        CrudService crudService = context.getBean(CrudService.class);
        crudService.get(new CrudBean(1l,"query param"));
    }
}
