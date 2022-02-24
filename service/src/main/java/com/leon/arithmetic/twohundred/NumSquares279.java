package com.leon.arithmetic.twohundred;

/**
  * ClassName:    NumSquares279
  * @Description: 279. 完全平方和
  * @Author:      liyang
  * @Date:        2022/2/18
  * version     1.0.0
 */
public class NumSquares279 {

    public static void main(String[] args){
        int i = numSquares(1000);
        System.out.println(i);
    }

    public static int numSquares2(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = n;
        }
        double sqrt = Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            for (int j = i*i; j <= n; j++) {
                if (j>=i*i){
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }
}