package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    PredictTheWinner
  * @Description: 486
  * @Author:      liyang
  * @Date:        2021/6/17
  * version     1.0.0
 */
public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        // dp[i][j]：在区间[i..j]中，自己作为先手，能获得的最大分数
        int[][] dp = new int[len][len];

        // 初始化，在区间只有一个数的时候，其本身必然就是最大分数
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        // 区间总是由小及大
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                // 选择净胜分更大的情况
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        // 要求区间[1..len]中的最大分数为正
        return dp[0][len - 1] >= 0;
    }

    public static void main(String[] args){
        PredictTheWinner winner = new PredictTheWinner();
        winner.predictTheWinner(new int[]{1,5,23,7});
    }
}