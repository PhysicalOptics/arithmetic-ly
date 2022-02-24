package com.leon.arithmetic.beibaoquestion;

/**
  * ClassName:    CoinChange322
  * @Description: 零钱兑换，硬币无限制，返回最少硬币数
  * @Author:      liyang
  * @Date:        2022/2/18
  * version     1.0.0
 */
public class CompletePackage04 {

    public static void main(String[] args){
        int i = coinChange(new int[]{2}, 4);
        System.out.println(i);
    }
    
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount+1;
            for (int coin : coins) {
                if (i>=coin){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        if (dp[amount]==amount+1) return -1;
        return dp[amount];
    }
}