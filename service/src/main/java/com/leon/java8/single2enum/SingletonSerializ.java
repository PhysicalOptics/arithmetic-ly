package com.leon.java8.single2enum;

/**
  * ClassName:    Singleton
  * @Description: 单例模式
  * @Author:      liyang
  * @Date:        2021/8/4
  * version     1.0.0
 */
public class SingletonSerializ implements java.io.Serializable {


    public static SingletonSerializ INSTANCE = new SingletonSerializ();

    protected SingletonSerializ() {
    }

    //反序列时直接返回当前INSTANCE
    private Object readResolve() {
        return INSTANCE;
    }


}