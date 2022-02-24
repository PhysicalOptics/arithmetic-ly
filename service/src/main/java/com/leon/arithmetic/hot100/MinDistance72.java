package com.leon.arithmetic.hot100;

/**
  * ClassName:    MinDistance72
  * @Description: 单词编辑距离
  * @Author:      liyang
  * @Date:        2021/9/23
  * version     1.0.0
 */
public class MinDistance72 {

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1+1][length2+1];
        dp[0][0] = 0;
        // 边界初始化
        for (int i = 1; i < length1+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < length2+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                int left = dp[i][j-1];
                int up = dp[i-1][j];
                int core = dp[i-1][j-1];
                // 只用处理当前比较的
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    core-=1;
                }
                dp[i][j] = 1+Math.min(left,Math.min(up,core));
            }
        }
        return dp[length1][length2];

    }
}