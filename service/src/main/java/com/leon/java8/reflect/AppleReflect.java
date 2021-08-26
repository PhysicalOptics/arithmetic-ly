package com.leon.java8.reflect;

/**
  * ClassName:    AppleReflectTest
  * @Description: 反射初级测试
  * @Author:      liyang
  * @Date:        2021/8/5
  * version     1.0.0
 */
public class AppleReflect {
    private String name;
    private Integer age;

    private AppleReflect(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}