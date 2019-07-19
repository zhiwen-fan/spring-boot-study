package com.bruce.springboot.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by bruce on 2019/1/31.
 */
@Aspect
@Configuration
@Order(2)
public class LogAspect {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.bruce.springboot.annotation.LogAnnotation)")
    public void log(){}

    @Around("log()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        String target = point.getTarget().getClass().getName() + "." + point.getSignature().getName();
        StringBuilder queryParam = new StringBuilder();
        for (Object param : point.getArgs()) {
            queryParam.append(JSON.toJSONString(param)).append(", ");
        }
        log.info("enter " + target + " with parameters: " + queryParam.toString());
        try {
            result = point.proceed(point.getArgs());
            log.info("execute " + target + " returned: " + JSON.toJSONString(result));
        }catch (Throwable throwable) {
            log.error("execute " + target + "failed:",throwable);
        }

        return result;
    }
}
