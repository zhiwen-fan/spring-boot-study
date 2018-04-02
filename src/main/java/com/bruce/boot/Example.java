package com.bruce.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bruce on 2018/4/2.
 */

@RestController
public class Example {

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/index")
    public String index() {
        return "index page";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "test2";
    }

}
