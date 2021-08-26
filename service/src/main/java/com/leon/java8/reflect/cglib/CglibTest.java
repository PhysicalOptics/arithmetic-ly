package com.leon.java8.reflect.cglib;

/**
  * ClassName:    CglibTest
  * @Description: cglib test
  * @Author:      liyang
  * @Date:        2021/8/6
 *
 *          final 类无法做cglib代理
  * version     1.0.0
 */
public class CglibTest {
    
    public static void main(String[] args){
        AdminCglibService target = new AdminCglibService();
        AdminServiceCglibProxy proxyFactor = new AdminServiceCglibProxy(target);
        AdminCglibService proxyInstance = (AdminCglibService)proxyFactor.getProxyInstance();
        Object o = proxyInstance.find();
    }

}