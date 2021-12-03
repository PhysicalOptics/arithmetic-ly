package com.leon.arithmetic.twohundred;

/**
  * ClassName:    IsPowerOfTwo231
  * @Description: 231. 2的幂
  * @Author:      liyang
  * @Date:        2021/11/15
  * version     1.0.0
 */
public class IsPowerOfTwo231 {

    public boolean isPowerOfTwo(int n) {
        while (n>1){
            int t = n % 2;
            if (t>0) return false;
            n=n/2;
        }
        return true;
    }
}