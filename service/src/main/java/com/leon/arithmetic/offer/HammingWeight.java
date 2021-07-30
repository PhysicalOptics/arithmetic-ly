package com.leon.arithmetic.offer;

/**
  * ClassName:    HammingWeight
  * @Description: 15
  * @Author:      liyang
  * @Date:        2021/6/23
  * version     1.0.0
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}