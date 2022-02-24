package com.leon.arithmetic.beibaoquestion;

/**
  * ClassName:    Package01
  * @Description: 完全背包
  * @Author:      liyang
  * @Date:        2022/2/15
  * version     1.0.0
 */
public class CompletePackage02 {

    // 多选，背包总和最大
    //价值最大，单选容量从大到小，多选从小到大
    public int maxValue(int n, int c, int[] v, int[] w) {
        int[] dp = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = v[i]; j <=c; j++) {
                dp[j] = Math.max(dp[j-v[i]]+w[i],dp[j]);
            }
        }
        return dp[c];
    }

    // 最少硬币数，达到目标的最少硬币数，从大硬币往小硬币选，外层amount，内存coin 大 ↓ 小
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];                     //   最少组和数
        for (int i = 0; i <= amount; i++) {                 //   int[] dp = new int[amount + 1];
            dp[i] = amount+1;                               //   dp[0] = 1;
        }                                                   //   for (int coin : coins) {
        dp[0] = 0;                                          //       for (int i = coin; i <= amount; i++) {
        for (int i = 1; i <= amount; i++) {                 //           dp[i] += dp[i-coin];
            for (int coin : coins) {                        //       }
                if (coin<=i){                               //   }
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);   //   return dp[amount];
                }
            }
            if (i==amount && dp[i]==amount+1) return -1;
        }
        return dp[amount];
    }


    //   最少组和数
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }


}  