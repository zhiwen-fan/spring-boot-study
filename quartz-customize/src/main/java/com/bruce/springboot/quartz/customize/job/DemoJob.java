package com.bruce.springboot.quartz.customize.job;

import com.bruce.springboot.quartz.customize.annotation.QuartzSchedule;
import org.springframework.stereotype.Component;

/**
 * Created by bruce on 2019/2/22.
 */
@Component
public class DemoJob {

    @QuartzSchedule(cronExpression = "0/2 * * * * ?",jobId = "demo1")
    public void demo1() {
        System.out.println("demo1 job is running ");
    }

    @QuartzSchedule(cronExpression = "0/5 * * * * ?",jobId = "demo2")
    public void demo2() {
        System.out.println("demo2 job is running ");
    }
}
