package com.leon.java8.reflect.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
  * ClassName:    AdminServiceInvocation
  * @Description: invacation
  * @Author:      liyang
  * @Date:        2021/8/5
  * version     1.0.0
 */
public class AdminServiceInvocation implements InvocationHandler {

    private Object target;

    public AdminServiceInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        Object invoke = method.invoke(target);

        return invoke;
    }
}