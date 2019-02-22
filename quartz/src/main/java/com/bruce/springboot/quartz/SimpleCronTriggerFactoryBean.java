package com.bruce.springboot.quartz;

import org.springframework.stereotype.Component;

/**
 * Created by bruce on 2019/2/21.
 */
@Component
public class SimpleCronTriggerFactoryBean extends AbstractCronTriggerFactoryBean {
    @Override
    String getCronExpression() {
        return "0/2 * * * * ?";
    }

    @Override
    Class getTargetJob() {
        return SimpleJob.class;
    }
}
