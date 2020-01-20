package com.bruce.springboot.extention;

import com.bruce.springboot.annotation.MarkAnnotation;
import com.bruce.springboot.service.CrudManager;
import com.bruce.springboot.service.CrudService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        MarkAnnotation annotation = bean.getClass().getAnnotation(MarkAnnotation.class);
        if(null == annotation) {
            return bean;
        }
        if(bean instanceof CrudService) {
            CrudManager.crudService = (CrudService)bean;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
