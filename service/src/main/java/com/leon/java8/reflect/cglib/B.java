package com.leon.java8.reflect.cglib;

import com.leon.java8.reflect.staticproxy.AdminService;

/**
  * ClassName:    B
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/8/6
  * version     1.0.0
 */
public final class B implements AdminService {
    private int i = 0;
    public static void main(String[] args){
        B b = new B();
        System.out.println(b.find());
        System.out.println(2134);
    }

    @Override
    public void update(String auth) {

    }

    @Override
    public String find() {
        return null;
    }
}