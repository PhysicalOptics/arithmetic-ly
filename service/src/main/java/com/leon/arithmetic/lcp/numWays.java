package com.leon.arithmetic.lcp;

/**
  * ClassName:    numWays
  * @Description: 007
  * @Author:      liyang
  * @Date:        2021/7/2
  * version     1.0.0
 */
public class numWays {
    public int numWays(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int j = 0; j < relation.length; j++) {
                int src = relation[j][0];
                int dst = relation[j][1];
                next[dst] += dp[src];
            }
            dp = next;
        }
        return dp[n-1];
    }
    public int numWays2(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
}