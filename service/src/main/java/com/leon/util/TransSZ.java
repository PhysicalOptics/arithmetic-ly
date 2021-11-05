package com.leon.util;

/**
  * ClassName:    TransSZ
  * @Description: 转换数组
  * @Author:      liyang
  * @Date:        2021/11/4
  * version     1.0.0
 */
public class TransSZ {
    public static void main(String[] args){
        String trans = trans("[[1,2,2],[3,8,2],[5,3,5]]");
        System.out.println(trans);
    }

    public static String trans(String s){
        return s.replace("[","{").replace("]","}");

    }
}