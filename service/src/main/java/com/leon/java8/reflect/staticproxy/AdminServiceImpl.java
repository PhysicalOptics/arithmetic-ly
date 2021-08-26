package com.leon.java8.reflect.staticproxy;

/**
  * ClassName:    AdminServiceImpl
  * @Description: 实现类
  * @Author:      liyang
  * @Date:        2021/8/5
  * version     1.0.0
 */
public class AdminServiceImpl implements AdminService{


    @Override
    public void update(String auth) {
        System.out.println("进入update方法");
    }

    @Override
    public String find() {
        System.out.println("进入find方法");
        return "find 返回结果";
    }
}