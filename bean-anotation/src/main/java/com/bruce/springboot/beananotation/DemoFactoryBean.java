package com.bruce.springboot.beananotation;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by bruce on 2019/2/21.
 */
public class DemoFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new DemoBean();
    }

    @Override
    public Class<?> getObjectType() {
        return DemoBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
