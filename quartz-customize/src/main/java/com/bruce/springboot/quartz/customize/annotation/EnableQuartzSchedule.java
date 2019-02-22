package com.bruce.springboot.quartz.customize.annotation;

import com.bruce.springboot.quartz.customize.core.QuartzScheduleBeanPostProcessor;
import com.bruce.springboot.quartz.customize.core.QuartzScheduleConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by bruce on 2019/2/22.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(value = {QuartzScheduleConfiguration.class,QuartzScheduleBeanPostProcessor.class})
public @interface EnableQuartzSchedule {
}
