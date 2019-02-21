package com.bruce.springboot.beananotation;

import org.springframework.stereotype.Component;

/**
 * Created by bruce on 2019/2/21.
 */
@Component
public class DemoRepository {

    public void demo() {
        System.out.println("demo repository");
    }
}
