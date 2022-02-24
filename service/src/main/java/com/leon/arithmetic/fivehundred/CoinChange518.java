package com.leon.arithmetic.fivehundred;

/**
  * ClassName:    CoinChange518
  * @Description: 518. 零钱兑换II  无限个硬币，凑成目标的组合数
  * @Author:      liyang
  * @Date:        2022/2/18
  * version     1.0.0
 */
public class CoinChange518 {

    public static void main(String[] args){
        int i = change(5,new int[]{1,2,5});
        System.out.println(i);
    }





    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}