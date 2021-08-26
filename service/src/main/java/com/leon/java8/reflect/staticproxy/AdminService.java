package com.leon.java8.reflect.staticproxy;

/**
  * ClassName:    AdminService
  * @Description: 接口类
  * @Author:      liyang
  * @Date:        2021/8/5
  * version     1.0.0
 */
public interface AdminService {
    void update(String auth);

    String find();
}