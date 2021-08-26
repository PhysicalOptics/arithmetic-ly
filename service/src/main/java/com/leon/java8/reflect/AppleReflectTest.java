package com.leon.java8.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
  * ClassName:    AppleReflectTest
  * @Description: 反射初级测试
  * @Author:      liyang
  * @Date:        2021/8/5
  * version     1.0.0
 */
public class AppleReflectTest {
    public static void main(String[] args) throws Exception {
        Method setName = AppleReflect.class.getMethod("setName", String.class);
        Constructor<AppleReflect> appConst = AppleReflect.class.getDeclaredConstructor();
        appConst.setAccessible(true);
        AppleReflect appleReflect = appConst.newInstance();
        setName.invoke(appleReflect,"methinvo");
        System.out.println(appleReflect.getName());

    }

}