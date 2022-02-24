package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    CanPartition416
  * @Description: 416. 分割等和子集
  * @Author:      liyang
  * @Date:        2022/2/15
  * version     1.0.0
 */
public class CanPartition416 {

    public static void main(String[] args){
        System.out.println(canPartition3(new int[]{1,5,11,5}));
    }

    public static boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2!=0) return false;
        int c= sum/2;
        boolean[] dp = new boolean[c + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = c; j >= nums[i]; j--) {
                dp[j] = dp[j-nums[i]] | dp[j];
            }
        }
        return dp[c];
    }

    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2!=0) return false;
        int c= sum/2;
        int[] dp = new int[c + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = c; j >=nums[i] ; j--) {
                if (dp[j-nums[i]]+nums[i]==c || dp[j]==c) return true;
                if (dp[j-nums[i]]+nums[i]<c){
                    dp[j] = Math.max(dp[j-nums[i]]+nums[i],dp[j]);
                }
            }
        }
        return false;

    }





































    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2!=0) return false;
        sum = sum/2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n +1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n +1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j-nums[i-1]<0){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j] =dp[i-1][j]|dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];

    }
}