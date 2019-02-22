package com.bruce.springboot.quartz.customize.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by bruce on 2019/2/22.
 */
public class MethodInvoker {

    private Object object;

    private Method method;

    public MethodInvoker(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    public void invoke() {
        try {
            method.invoke(object,null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
