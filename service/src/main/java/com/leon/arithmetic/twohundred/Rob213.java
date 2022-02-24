package com.leon.arithmetic.twohundred;

import java.util.Arrays;

/**
  * ClassName:    Rob213
  * @Description: 213. 打家劫舍II （围成一圈）
  * @Author:      liyang
  * @Date:        2021/12/23
  * version     1.0.0
 */
public class Rob213 {

    public static void main(String[] args){
        int[] a = {1,2,3,1};
        //int[] arr1 = Arrays.copyOf(a, a.length - 1);
        //System.out.println(arr1);
        //int[] arr2 = new int[a.length - 1];
        //System.arraycopy(a,1, arr2,0,a.length - 1);
        //System.out.println(arr2);
        //
        //int[] arr3 = Arrays.copyOfRange(a, 1, a.length);
        //System.out.println(arr3);
        Rob213 rob213 = new Rob213();
        rob213.rob(a);
    }

    public int rob(int[] nums) {
        //int[] arr2 = new int[nums.length - 1];
        int[] arr1 = Arrays.copyOf(nums, nums.length - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1,nums.length);
        //System.arraycopy(nums,1, arr2,0,nums.length - 1);
        return Math.max(subrob(arr1),subrob(arr2));
    }

    public int subrob(int[] nums){
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i-1]+nums[i],dp[i]);
        }
        return dp[nums.length];
    }

    private int myRob(int[] nums) {
        int pre=0,cur=nums[0],temp;
        for (int i = 1; i < nums.length; i++) {
            temp = cur;
            cur = Math.max(pre+nums[i],cur);
            pre = temp;
        }
        return cur;
    }
}