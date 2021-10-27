package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    MinMoves453
  * @Description: 453. 最少操作使相等
  * @Author:      liyang
  * @Date:        2021/10/20
  * version     1.0.0
 */
public class MinMoves453 {
    public int minMoves(int[] nums) {
        // 由数学公式推导 （min+k次）n=sum0+(n-1)k  --> k = sum0-n*min
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        return sum-nums.length*min;
        
    }
}