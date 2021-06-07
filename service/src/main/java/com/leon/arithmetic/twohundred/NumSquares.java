package com.leon.arithmetic.twohundred;

/**
  * ClassName:    NumSquares
  * @Description: 279
  * @Author:      liyang
  * @Date:        2021/4/28
  * version     1.0.0
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n+1; i++) {
            dp[i] = n+1;
        }
        int s = 1;
        while (s*s<n){
            s++;
        }
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j < s ; j++) {
                if (j*j<=i){
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                }
            }
        }
        return dp[n];

    }
}