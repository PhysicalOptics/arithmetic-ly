package com.leon.arithmetic.twohundred;

/**
  * ClassName:    NthUglyNumber
  * @Description: 264
  * @Author:      liyang
  * @Date:        2021/4/12
  * version     1.0.0
 */
public class NthUglyNumber {
    public static int nthUglyNumber(int n) {
        int idx2=0,idx3=0,idx5=0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num2 = dp[idx2] * 2;
            int num3 = dp[idx3] * 3;
            int num5 = dp[idx5] * 5;
            dp[i]=Math.min(Math.min(num2,num3),num5);
            if (dp[i]==num2){
                idx2++;
            }else if (dp[i]==num3){
                idx3++;
            }else if (dp[i]==num5){
                idx5++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        nthUglyNumber(10);
        System.out.println(1);
    }
}