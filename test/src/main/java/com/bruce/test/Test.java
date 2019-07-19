package com.bruce.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "test";
    }

}
