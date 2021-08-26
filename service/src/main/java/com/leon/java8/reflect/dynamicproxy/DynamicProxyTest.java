package com.leon.java8.reflect.dynamicproxy;

import com.leon.java8.reflect.staticproxy.AdminService;
import com.leon.java8.reflect.staticproxy.AdminServiceImpl;

import java.lang.reflect.Proxy;

/**
  * ClassName:    dynamicProxyTest
  * @Description: 动态代理测试
  * @Author:      liyang
  * @Date:        2021/8/6
  * version     1.0.0
 */
public class DynamicProxyTest {

    public static void main(String[] args){
        System.out.println("-------------方法一-------------");
        AdminService adminService = new AdminServiceImpl();
        System.out.println("代理的目标对象"+adminService.getClass());
        AdminServiceInvocation adminServiceInvocation = new AdminServiceInvocation(adminService);
        AdminService proxy = (AdminService)new AdminServiceDynamicProxy(adminService, adminServiceInvocation).getPersonProxy();
        System.out.println("代理对象："+proxy.getClass());
        System.out.println("proxy.find()"+proxy.find());

        System.out.println("-----------方法二---------------");
        AdminService target = new AdminServiceImpl();
        AdminServiceInvocation invocation = new AdminServiceInvocation(target);
        AdminService proxy2 = (AdminService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocation);
        System.out.println("proxy2"+proxy.getClass());

        System.out.println("--------------------------");
    }

}