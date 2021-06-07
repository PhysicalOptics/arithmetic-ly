package com.leon.arithmetic.threehundred;

/**
  * ClassName:    CoinChange
  * @Description: 322
  * @Author:      liyang
  * @Date:        2021/4/27
  * version     1.0.0
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin<=i){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
            if (i==amount && dp[i]==amount+1) return -1;
        }
        return dp[amount];
    }
    
    public static void main(String[] args){
        System.out.println(coinChange(new int[]{ 2, 5},3));
    }
}