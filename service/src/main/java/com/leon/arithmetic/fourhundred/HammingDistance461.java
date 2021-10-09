package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    HammingDistance461
  * @Description: 461.汉明距离
  * @Author:      liyang
  * @Date:        2021/10/9
  * version     1.0.0
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int n = x^y,r= 0;
        while(n!=0){
            int i = n % 2;
            if (i==1) r++;
            n=n/2;
        }
        Integer.bitCount(4);
        return r;
    }
}