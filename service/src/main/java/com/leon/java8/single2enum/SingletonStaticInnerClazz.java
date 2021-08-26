package com.leon.java8.single2enum;

import java.lang.reflect.Constructor;

/**
  * ClassName:    SingletonDoubleCheck
  * @Description: 静态内部类实现
 *              静态内部类项目初始化时就执行，内部类的局部变量初始化
  * @Author:      liyang
  * @Date:        2021/8/4
  * version     1.0.0
 */
public class SingletonStaticInnerClazz {
    private static class Singleton{
        private static SingletonStaticInnerClazz singleton = new SingletonStaticInnerClazz();
    }
    private SingletonStaticInnerClazz(){}

    public static SingletonStaticInnerClazz getSingleton(){
        return Singleton.singleton;
    }
    public static void main(String[] args){
        try {
            Constructor<SingletonStaticInnerClazz> constructor = SingletonStaticInnerClazz.class.getConstructor();
            SingletonStaticInnerClazz si = constructor.newInstance();
            SingletonStaticInnerClazz.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
