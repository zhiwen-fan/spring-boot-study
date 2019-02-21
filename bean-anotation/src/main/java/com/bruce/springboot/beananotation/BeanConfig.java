package com.bruce.springboot.beananotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bruce on 2019/2/21.
 */
@Configuration
public class BeanConfig {

    @Bean
    public DemoService demoService() {
        return new DemoService();
    }

    @Bean
    public DemoFactoryBean demoFactoryBean() {
        return new DemoFactoryBean();
    }
}
