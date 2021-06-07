package com.leon.arithmetic.threehundred;

import java.util.Arrays;

/**
  * ClassName:    MaxEnvelopes
  * @Description: 354
  * @Author:      liyang
  * @Date:        2021/3/4
  * version     1.0.0
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // for找出最大w 找出最大h
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        int lengthOfLIS = maxEnvelopes.lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length<2) return length;
        int[] tails = new int[length];
        tails[0]=nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>tails[res]){
                res++;
                tails[res]=nums[i];
            }else {
                int l=0,r=res;
                while (l<r){
                    int m = (l+r)/2;
                    if (nums[i]>tails[m]){
                        l=m+1;
                    }else {
                        r=m;
                    }
                }
                tails[l] = nums[i];
            }
        }
//        return ++res;
        /*for (int num : nums) {
            // tail的起始
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                // 取中位数，如果中位数小于当前值，继续从中位数往后找
                if(tails[m] < num) i = m + 1;
                // 降低j,继续二分
                else j = m;
            }
            tails[i] = num;
            // 如果经过while处理j还不变++
            if(res == j) res++;
        }*/
        return res;
        
        
        
        
        
        
        
        
        
        /*int length = nums.length;
        if (length<2) return length;
        int[] dp = new int[length];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
                res = Math.max(res,dp[i]);
            }

        }
        return res;*/
    }
}