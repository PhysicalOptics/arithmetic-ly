package com.leon.arithmetic.thousand;

import java.util.Arrays;

/**
  * ClassName:    LongestCommonSubsequence1143
  * @Description: 最长公共子序列
  * @Author:      liyang
  * @Date:        2021/11/8
  * version     1.0.0
 */
public class LongestCommonSubsequence1143 {

    public static void main(String[] args){
        LongestCommonSubsequence1143 subsequence1143 = new LongestCommonSubsequence1143();
        int i = subsequence1143.longestCommonSubsequence2("abcde", "ace");
        System.out.println(i);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int max = Math.max(dp[i-1][j],dp[i][j-1]);
                if (s1[i-1]==s2[j-1]){
                    max = dp[i-1][j-1]+1;
                }
                dp[i][j] = max;
            }
        }
        return dp[m][n];

    }

    // 收缩为1维
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        for(int i = 1; i < m + 1; i++) {
            // 每一行如果有一个相等则可以提升1级，
            int pre = 0;
            for(int j = 1; j < n + 1; j++) {
                int temp = dp[j];
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;
                }else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                pre = temp;
            }
        }
        return dp[n];
    }
}