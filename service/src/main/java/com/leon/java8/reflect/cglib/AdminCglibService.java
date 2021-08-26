package com.leon.java8.reflect.cglib;

/**
  * ClassName:    AdminCglibService
  * @Description: 实例类
  * @Author:      liyang
  * @Date:        2021/8/6
  * version     1.0.0
 */
public class AdminCglibService {
    public void update() {
        System.out.println("修改管理系统数据");
    }

    public Object find() {
        System.out.println("查看管理系统数据");
        return new Object();
    }
}