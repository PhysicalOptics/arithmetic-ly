package com.leon.arithmetic.hot100;

/**
  * ClassName:    MaxSubArray
  * @Description: 53最大子序和
  * @Author:      liyang
  * @Date:        2021/9/22
  * version     1.0.0
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        if (nums.length==1) return nums[0];
        int ret = nums[0];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            ret = Math.max(ret, max);
        }
        return ret;
    }
}