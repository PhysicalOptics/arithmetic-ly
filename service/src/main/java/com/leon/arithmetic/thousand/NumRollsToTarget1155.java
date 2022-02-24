package com.leon.arithmetic.thousand;

/**
  * ClassName:    NumRollsToTarget1155
  * @Description: 1155. 掷骰子的N种方式
  * @Author:      liyang
  * @Date:        2022/2/21
 * 	0	1	2	3	4	5	6	7	8	9	10	11	12
 * 0	1	0	0	0	0	0	0	0	0	0	0	0	0
 * 1	0	1	1	1	1	1	1	0	0	0	0	0	0
 * 2	0	0	1	2	3	4	5	6	5	4	3	2	1
 * 3	0	0	0	1	3	6	10
  * version     1.0.0
 */
public class NumRollsToTarget1155 {

    public static void main(String[] args){
        numRollsToTarget2(3,6,12);
    }

    static int mod = (int) 1e9+7;
    // n个k面的骰子，组成一个target的方法
    public static int numRollsToTarget2(int n, int k, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j > 0; j--) {
                f[j] = 0; // 寻找这层的最多解法,
                for (int e = 1; e <= k; e++) {
                    if (j >= e) {
                        f[j] = (f[j] + f[j-e]) % mod;
                    }
                }
            }
        }
        return f[target];
    }


    public static int numRollsToTarget(int n, int m, int t) {
        int[][] f = new int[n + 1][t + 1];
        f[0][0] = 1;
        // 枚举物品组（每个骰子）
        for (int i = 1; i <= n; i++) {
            // 枚举背包容量（所掷得的总点数）
            for (int j = 1; j <= t; j++) {
                // 枚举决策（当前骰子所掷得的点数）
                for (int k = 1; k <= m && j>=k&&j<=i*6; k++) {
                    f[i][j] = (f[i][j] + f[i-1][j-k]) % mod;
                }
            }
        }
        return f[n][t];
    }
}