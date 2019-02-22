package com.bruce.springboot.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

/**
 * Created by bruce on 2019/2/21.
 */
public abstract class AbstractCronTriggerFactoryBean extends CronTriggerFactoryBean {
    public AbstractCronTriggerFactoryBean() {
        init();
    }

    public void init() {
        JobDetail jobDetail = JobBuilder.newJob().ofType(getTargetJob()).withIdentity(getTargetJob().getName()).build();
        this.setJobDetail(jobDetail);
        this.setCronExpression(getCronExpression());
    }
    abstract String getCronExpression();

    abstract Class getTargetJob();
}
