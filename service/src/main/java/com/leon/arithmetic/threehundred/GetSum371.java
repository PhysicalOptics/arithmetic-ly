package com.leon.arithmetic.threehundred;

/**
  * ClassName:    GetSum371
  * @Description: 两整数和采用位运算
  * @Author:      liyang
  * @Date:        2021/9/26
  * version     1.0.0
 */
public class GetSum371 {

    public int getSum(int a, int b) {
        int sum = a|b;
        while ((a & b) != 0){
            int i = a ^ b;
            int y = a & b;
            a=y<<1;
            b=i;
            sum = a|b;
        }
        return sum;
    }
}