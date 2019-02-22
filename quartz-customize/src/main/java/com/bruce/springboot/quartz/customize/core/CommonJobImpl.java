package com.bruce.springboot.quartz.customize.core;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by bruce on 2019/2/22.
 */
public class CommonJobImpl implements Job {

    private MethodInvoker methodInvoker;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Object methodInvoker = jobExecutionContext.getJobDetail().getJobDataMap().get("methodInvoker");
        setMethodInvoker((MethodInvoker)methodInvoker);
        this.methodInvoker.invoke();
    }

    public void setMethodInvoker(MethodInvoker methodInvoker) {
        this.methodInvoker = methodInvoker;
    }
}
