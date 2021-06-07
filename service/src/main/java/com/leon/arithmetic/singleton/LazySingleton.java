package com.leon.arithmetic.singleton;

/**
  * ClassName:    LazySingleton
  * @Description: 
  * @Author:      liyang
  * @Date:        2020/8/5
  * version     1.0.0
 */
public class LazySingleton {
/*    private static final LazySingleton singleton = new LazySingleton();

    public static LazySingleton getInstance(){
        return singleton;
    }

    private LazySingleton(){}*/
    private LazySingleton(){}

    private static volatile LazySingleton singleton;

    // 反射和序列化可以破坏，单例建议用枚举
    public static LazySingleton getInstance(){
        if (singleton == null){
            synchronized (LazySingleton.class){
                if (singleton == null){
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}

enum SingtonEnum{
    SINGTON;


}