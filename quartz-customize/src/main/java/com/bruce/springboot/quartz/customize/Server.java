package com.bruce.springboot.quartz.customize;

import com.bruce.springboot.quartz.customize.annotation.EnableQuartzSchedule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by bruce on 2019/2/22.
 */
@SpringBootApplication
@EnableQuartzSchedule
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class,args);
    }
}
