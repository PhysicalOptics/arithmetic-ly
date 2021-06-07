package com.leon.arithmetic.hundred;

/**
  * ClassName:    ReverseInt
  * @Description: 7
  * @Author:      liyang
  * @Date:        2021/3/29
  * version     1.0.0
 */
public class ReverseInt {
    public int reverse(int x) {
        int res = 0;
        while (x!=0){
            int i = x % 10;
            if (res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&i>7)) return 0;
            if (res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&i<-8)) return 0;
            res = res*10+i;
            x=x/10;
        }
        return res;
    }

    public boolean isPalindrome(int x) {
        int res = 0;
        int t = x;
        while (t!=0){
            res = res*10+t%10;
            t=t/10;
        }
        return res == x;
    }


    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = ret*2+n%2;
            n/=2;
        }
        return ret;
    }
}