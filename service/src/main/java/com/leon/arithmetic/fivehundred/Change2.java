package com.leon.arithmetic.fivehundred;

/**
  * ClassName:    Change2
  * @Description: 518
  * @Author:      liyang
  * @Date:        2021/4/28
  * version     1.0.0
 */
public class Change2 {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
    
    public static void main(String[] args){
        System.out.println(change(27,new int[]{1,2,5}));
    }
}