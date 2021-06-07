package com.leon.arithmetic.threehundred;

import java.util.Arrays;

/**
  * ClassName:    CombinationSum4
  * @Description: 377
  * @Author:      liyang
  * @Date:        2021/4/26
  * version     1.0.0
 */
public class CombinationSum4 {
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