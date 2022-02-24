package com.leon.arithmetic.twohundred;

import java.util.HashSet;

/**
  * ClassName:    IsHappy202
  * @Description: 202. 快乐数
  * @Author:      liyang
  * @Date:        2021/12/6
  * version     1.0.0
 */
public class IsHappy202 {

    public static void main(String[] args){
        System.out.println(isHappy(2));


    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (n!=1){
            int sum = 0;
            while (n>0){
                int i = n % 10;
                sum += i*i;
                n = n/10;
            }
            n = sum;
            if (!set.add(n)) return false;
        }
        if (n==1) return true;
        else return false;
    }
}