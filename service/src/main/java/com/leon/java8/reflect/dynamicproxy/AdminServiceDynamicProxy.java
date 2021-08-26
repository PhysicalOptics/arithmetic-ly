package com.leon.java8.reflect.dynamicproxy;

import java.lang.reflect.Proxy;

/**
  * ClassName:    AdminServiceDynamicProxy
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/8/5
  * version     1.0.0
 */
public class AdminServiceDynamicProxy {

    private Object target;
    private AdminServiceInvocation adminServiceInvocation;

    public AdminServiceDynamicProxy(Object target, AdminServiceInvocation adminServiceInvocation) {
        this.target = target;
        this.adminServiceInvocation = adminServiceInvocation;
    }

    public Object getPersonProxy(){
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), adminServiceInvocation);
        return o;
    }

}