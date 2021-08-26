package com.leon.java8.single2enum;

/**
  * ClassName:    Singleton
  * @Description: 单例模式
  * @Author:      liyang
  * @Date:        2021/8/4
  * version     1.0.0
 */
public class SingletonSerialFinal implements java.io.Serializable {

    public static SingletonSerialFinal INSTANCE = new SingletonSerialFinal();
    private static volatile  boolean  flag = true;
    // 解决反序列化修改构造器问题
    private SingletonSerialFinal(){
        if(flag){
            flag = false;
        }else{
            throw new RuntimeException("The instance  already exists ！");
        }
    }

    //反序列时直接返回当前INSTANCE
    private Object readResolve() {
        return INSTANCE;
    }

}