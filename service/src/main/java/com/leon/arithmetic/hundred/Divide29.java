package com.leon.arithmetic.hundred;

/**
  * ClassName:    Divide29
  * @Description: 29、两数相除
  * @Author:      liyang
  * @Date:        2021/10/12
  * version     1.0.0
 */
public class Divide29 {

    public static void main(String[] args){
        Divide29 divide29 = new Divide29();
        divide29.divide2(1273741824,3);
    }

    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int LIMIT = -1073741824; // MIN 的一半
    public int divide2(int a, int b) {
        if (a == MIN && b == -1) return MAX;
        boolean flag = false;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) flag = true;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int ans = 0;
        while (a <= b){
            int c = b, d = -1;
            // 指数增长被除数，判断是否能减，能就商加上d
            while (c >= LIMIT && d >= LIMIT && c >= a - c){
                c += c; d += d;
            }
            a -= c;
            ans += d;
        }
        return flag ? ans : -ans;
    }


    public int divide(int dividend, int divisor) {
        // 1则为负数，0为正数
        int i = ((dividend ^ divisor) >>> 31) & 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ret = 0;
        while (dividend>=divisor){
            dividend = dividend-divisor;
            ret++;
        }
        if (i==1) return 0-ret;
        return ret;
    }

}