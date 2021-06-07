package com.leon.arithmetic.twohundred;

/**
  * ClassName:    IsUgly
  * @Description: 263
  * @Author:      liyang
  * @Date:        2021/4/12
  * version     1.0.0
 */
public class IsUgly {
    public boolean isUgly(int n) {
        if (n==1) return true;
        while (n!=0){
            boolean f = true;
            if (n%2==0){
                n/=2;
                f = false;
            }
            if (n%3==0){
                n/=3;
                f = false;
            }
            if (n%5 ==0){
                n/=5;
                f = false;
            }
            if (f){
                return false;
            }else if (n==1){
                return true;
            }
        }
        return true;


    }
}