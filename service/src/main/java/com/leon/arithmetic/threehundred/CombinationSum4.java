package com.leon.arithmetic.threehundred;

import java.util.Arrays;

/**
  * ClassName:    CombinationSum4
  * @Description: 377
  * @Author:      liyang
  * @Date:        2021/4/26
  * version     1.0.0
 * 不同 整数组成的数组 nums ，和一个目标整数 target,求组和数
 */
public class CombinationSum4 {
    public int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i-nums[j]>=0){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }



















    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];

        //        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        for (int i = 1; i <= target; i++) {
//            for (int num : nums) {
//                if (i>=num) dp[i] += dp[i-num];
//            }
//        }
//        return dp[target];
    }

    public static void main(String[] args){

        System.out.println(combinationSum4(new int[]{4,2,6},8));
    }
//    public int combinationSum(int[] nums, int target) {
//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//
//        for (int i = 1; i <= target; i++) {
//            for (int num : nums) {
//                if (num <= i) {
//                    dp[i] += dp[i - num];
//                }
//            }
//        }
//        return dp[target];
//    }



    private void dfs(int[] nums,int target,int index){
        if (target==0){
//            result++;
        }

        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] <0) break;
            dfs(nums, target - nums[i],index);

        }
    }
}