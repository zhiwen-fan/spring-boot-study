package com.bruce.springboot.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by bruce on 2019/2/20.
 */
@Configuration
@EnableScheduling
public class SpringBootTaskConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler  taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("spring-boot-task-thread");
        return taskScheduler;
    }
}
