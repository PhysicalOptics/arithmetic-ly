package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    FindMaxForm474
  * @Description: 474,一和零 多维背包， 限制0和1的个数，最大子集个数
  * @Author:      liyang
  * @Date:        2022/2/23
  * version     1.0.0
 */
public class FindMaxForm474 {
    public static void main(String[] args){
        //["10","0001","111001","1","0"]
        //5
        //3
        findMaxForm(new String[]{"10","0001","111001","1","0"},5,3);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] ss = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int zero = 0,one =0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j)=='0') zero++;
                else one++;
            }
            ss[i] = new int[]{zero,one};
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int zero = ss[i][0],one=ss[i][1];
            for (int j = m; j >=zero; j--) {
                for (int k = n; k >=one; k--) {
                    dp[j][k] = Math.max(dp[j][k],dp[j-zero][k-one]+1);
                }
            }
        }
        return dp[m][n];
    }
}