package com.leon.arithmetic.fivehundred;

/**
  * ClassName:    MinDistance583
  * @Description: 583. 删除字符串
  * @Author:      liyang
  * @Date:        2022/1/29
  * version     1.0.0
 */
public class MinDistance583 {

    public static void main(String[] args){
        String s = "adfasd邮寄包:123123";
        String[] split = s.split("邮寄包:");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }

    // 找出相同的子序列
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m = s1.length;
        int n = s2.length;
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

        return m+n-dp[m][n]*2;
    }

    public int minDistance2(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            //每次循环一行的时候，开始左上都为0
            int pre = 0;
            for (int j = 1; j <= n; j++) {
                //将当前上方的数字存起来作为下次循环的左上
                int temp = dp[j];
                if (s1[i-1]==s2[j-1]){
                    // 相等左上加一
                    dp[j] = pre + 1;
                }else {
                    // 不相等则根据dp数据取最大值，dp刚好是上方和左方
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
                //更新左上数据
                pre = temp;
            }
        }
        return m+n-dp[n]*2;
    }

}