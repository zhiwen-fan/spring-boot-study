package com.bruce.springboot.beananotation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bruce on 2019/2/21.
 */
public class DemoService implements InitializingBean {
    @Autowired
    private DemoRepository demoRepository;

    public void demo() {
        demoRepository.demo();
        System.out.println("demo service");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
