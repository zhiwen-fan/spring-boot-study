package com.bruce.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
public class PerformanceAspect {

    Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.bruce.springboot.annotation.PerformanceAnnotation)")
    public void performance(){}


    @Around("performance()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long start = System.currentTimeMillis();
        log.info("enter time is: " + start);
        try {
            result = point.proceed(point.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            long end = System.currentTimeMillis();
            log.info("end time is : " + end);
            String method = point.getTarget().getClass().getName() + point.getSignature().getName();
            log.info("invoke method " + method + "cost time: " + (end - start));
        }

        return result;
    }
}
