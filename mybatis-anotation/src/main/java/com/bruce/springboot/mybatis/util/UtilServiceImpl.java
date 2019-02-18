package com.bruce.springboot.mybatis.util;

import org.springframework.stereotype.Service;

/**
 * Created by bruce on 2018/9/5.
 */
@Service
public class UtilServiceImpl implements UtilService {

    @Override
    public void print() {
        System.out.println("print something");
    }
}
