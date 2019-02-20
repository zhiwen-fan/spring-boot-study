package com.bruce.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by bruce on 2019/2/20.
 */
@Component
public class SpringTaskBean {

    @Scheduled(cron = "0/5 * * * * *")
    public void task1() throws InterruptedException {
        System.out.println("task1 is running with thread: "+ Thread.currentThread().getName());
        Thread.sleep(2000);
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void task2() {
        System.out.println("task2 is running with thread: "+ Thread.currentThread().getName());
    }
}
