package com.leon.java8.single2enum;

/**
  * ClassName:    SingletonDoubleCheck
  * @Description: 双检查锁
 *              饿汉直接在局部变量new 静态 ↓
 *              在getSingleton方法上加synchronized ↓
 *              当前双重检查锁，加volatile防止指令重排导致，还没初始化完就被第二个线程用了
  * @Author:      liyang
  * @Date:        2021/8/4
  * version     1.0.0
 */
public class SingletonDoubleCheck {
    private static volatile SingletonDoubleCheck singleton = null;

    private SingletonDoubleCheck(){}

    public static SingletonDoubleCheck getSingleton(){
        if(singleton == null){
            synchronized (SingletonDoubleCheck.class){
                if(singleton == null){
                    singleton = new SingletonDoubleCheck();
                }
            }
        }
        return singleton;
    }
}
