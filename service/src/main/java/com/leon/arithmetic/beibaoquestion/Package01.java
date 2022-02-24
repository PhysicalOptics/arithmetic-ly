package com.leon.arithmetic.beibaoquestion;

import java.util.HashMap;

/**
  * ClassName:    Package01
  * @Description: 01背包
  * @Author:      liyang
  * @Date:        2022/2/15
  * version     1.0.0
 */
public class Package01 {

    // 单选只能选一次，容量从大到小
    public int maxValue(int n, int c, int[] v, int[] w) {
        int[] dp = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = c; j >=v[i]; j--) {
                dp[j] = Math.max(dp[j-v[i]]+w[i],dp[j]);
            }
        }
        return dp[c];
    }

    /*
    * 空间维度优化：由于正序是由上层本位和上层i-v[i]位的值决定，如果优化成一维，继续正序推算，会覆盖n-v[i]的值，无法得出本位值
    * 所以倒序，1维的前数和本位数依旧还是上层值，则可以替换计算出最新本位数
    */

    public int maxValuepre(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[N][C+1];
        // 先处理「考虑第一件物品」的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = i >= v[0] ? w[0] : 0;
        }
        // 再处理「考虑其余物品」的情况
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C + 1; j++) {
                // 不选该物品
                int n = dp[i-1][j];
                // 选择该物品，前提「剩余容量」大于等于「物品体积」
                int y = j >= v[i] ? dp[i-1][j-v[i]] + w[i] : 0;
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[N-1][C];
    }

}  