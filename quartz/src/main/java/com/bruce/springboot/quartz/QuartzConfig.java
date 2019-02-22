package com.bruce.springboot.quartz;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Created by bruce on 2019/2/21.
 */
@Configuration
public class QuartzConfig {

    @Bean
    SchedulerFactoryBean schedulerFactoryBean(Trigger[] triggers) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(triggers);
        return schedulerFactoryBean;
    }
}
