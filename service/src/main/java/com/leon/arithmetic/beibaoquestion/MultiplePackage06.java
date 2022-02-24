package com.leon.arithmetic.beibaoquestion;

/**
  * ClassName:    MultiplePackage05
  * @Description: 多重背包，物品有数量限制
  * @Author:      liyang
  * @Date:        2022/2/21
  * version     1.0.0
 */
public class MultiplePackage06 {

    // 压缩数量维度，只能选一次，拆解成二进制
    public static void main(String[] args){
        int val = 10;

        for (int k = 1; k <= val; k *= 2) {
            val -= k;
            System.out.println(k);
        }
    }
    public int maxValue(int N, int C, int[] s, int[] v, int[] w) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < N; i++) {
            // 限制能选的物品
            for (int j = C; j >= v[i]; j--) {
                //限制物品选择的数量，从一个个物品选推论
                for (int k = 0; k < s[i] && j >= k * v[i]; k++) {
                    dp[i] = Math.max(dp[i],dp[i-k*v[i]]+k*w[i]);
                }
            }
        }
        return dp[C];
    }

}