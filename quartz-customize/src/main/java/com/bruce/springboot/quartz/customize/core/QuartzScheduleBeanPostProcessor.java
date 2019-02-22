package com.bruce.springboot.quartz.customize.core;

import com.bruce.springboot.quartz.customize.annotation.QuartzSchedule;
import org.quartz.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;

/**
 * Created by bruce on 2019/2/22.
 */
public class QuartzScheduleBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Method[] methods = o.getClass().getDeclaredMethods();
        for (Method method: methods) {
            QuartzSchedule annotation = method.getAnnotation(QuartzSchedule.class);
            if(null == annotation) {
                continue;
            }
            registerTriggerToSchedule(generateJob(annotation.jobId(),o,method),generateJobTrigger(annotation.cronExpression(), annotation.jobId()));
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Trigger generateJobTrigger(String cronExpression, String jobId) {
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(jobId)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
        return cronTrigger;
    }

    private JobDetail generateJob(String jobId, Object object, Method method) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("methodInvoker",new MethodInvoker(object,method));
        JobDetail jobDetail = JobBuilder.newJob()
                .ofType(CommonJobImpl.class)
                .withIdentity(jobId)
                .setJobData(jobDataMap)
                .build();
        return jobDetail;
    }

    private void registerTriggerToSchedule(JobDetail jobDetail,Trigger trigger) {
        Scheduler scheduler = applicationContext.getBean(Scheduler.class);
        try {
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
