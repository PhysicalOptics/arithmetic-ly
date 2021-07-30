package com.leon.arithmetic.ninehundred;

/**
  * ClassName:    NumSubarraysWithSum
  * @Description: 930
  * @Author:      liyang
  * @Date:        2021/7/8
  * version     1.0.0
 */
public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int length = nums.length;
        int ret = 0;
        for (int i = 0; i < length; i++) {
            int temp = i,sum = 0;
            while (sum<=goal && temp<length){
                sum += nums[temp];
                if (sum==goal) ret++;
                temp++;
            }
        }
        return ret;
    }
}