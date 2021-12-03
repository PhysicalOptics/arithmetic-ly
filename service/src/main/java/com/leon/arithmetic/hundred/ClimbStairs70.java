package com.leon.arithmetic.hundred;

/**
  * ClassName:    ClimbStairs70
  * @Description: 70. 爬楼梯
  * @Author:      liyang
  * @Date:        2021/11/15
  * version     1.0.0
 */
public class ClimbStairs70 {
    public static void main(String[] args){
        climbStairs(5);
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}