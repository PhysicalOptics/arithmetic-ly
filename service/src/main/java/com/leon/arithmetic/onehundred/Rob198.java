package com.leon.arithmetic.onehundred;

/**
  * ClassName:    Rob198
  * @Description: 198. 打家劫舍
  * @Author:      liyang
  * @Date:        2021/11/15
  * version     1.0.0
 */
public class Rob198 {

    public static void main(String[] args){
        int rob = rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
    
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length+1; i++) {
            dp[i] = Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        }
        return dp[nums.length];
    }
}