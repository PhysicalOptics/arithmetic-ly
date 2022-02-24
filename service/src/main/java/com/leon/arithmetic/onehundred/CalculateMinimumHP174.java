package com.leon.arithmetic.onehundred;

/**
  * ClassName:    CalculateMinimumHP174
  * @Description: 174. 地下城游戏魔塔
  * @Author:      liyang
  * @Date:        2022/1/5
  * version     1.0.0
 */
public class CalculateMinimumHP174 {

    public static void main(String[] args){
        CalculateMinimumHP174 minimumHP174 = new CalculateMinimumHP174();
        int i = minimumHP174.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
        System.out.println(i);
    }


    // 倒推从最后一个开始所需的最小生命数
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //m-1-i,n-1-i
                if (i==0&&j==0){
                    dp[m-1][n-1] = -dungeon[m-1][n-1]>0?-dungeon[m-1][n-1]:0;
                    continue;
                }
                if (i==0){
                    int hp = dp[m - 1][n - 1 - j + 1] - dungeon[m - 1][n - 1 - j];
                    dp[m-1][n-1-j] = hp >0?hp:0;
                    continue;
                }
                if (j==0){
                    int hp = dp[m - 1 - i + 1][n - 1] - dungeon[m - 1 - i][n - 1];
                    dp[m-1-i][n-1] = hp>0?hp:0;
                    continue;
                }
                int hpmin = Math.min(dp[m - 1 - i + 1][n - 1 - j], dp[m - 1 - i][n - 1 - j + 1]) - dungeon[m - 1 - i][n - 1 - j];
                dp[m-1-i][n-1-j] = hpmin>0?hpmin:0;
            }
        }
        return dp[0][0]+1;

    }

}