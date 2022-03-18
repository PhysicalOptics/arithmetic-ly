package com.leon.arithmetic.stonegame;

/**
  * ClassName:    StoneGame877
  * @Description: 877. 石头游戏
  * @Author:      liyang
  * @Date:        2022/2/25
  * version     1.0.0
 */
public class StoneGame877 {

    public boolean stoneGame2(int[] piles) {
        int leng = piles.length;
        int[] dp = new int[leng];
        for (int i = 0; i < leng; i++) {
            dp[i]=piles[i];
        }
        for (int i = leng-2; i >=0; i++) {
            for (int j = i+1; j < leng; j++) {
                dp[j] = Math.max(piles[i]-dp[j],piles[j]-dp[j-1]);
            }
        }
        return dp[leng-1]>0;
    }
    public boolean stoneGame(int[] piles) {
        int leng = piles.length;
        int[][] dp = new int[leng][leng];
        for (int i = 0; i < leng; i++) {
            dp[i][i]= piles[i];
        }
        for (int i = leng-2; i >=0 ; i--) {
            for (int j = i+1; j < leng; j++) {
                dp[i][j] = Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][leng-1]>0;
    }

}