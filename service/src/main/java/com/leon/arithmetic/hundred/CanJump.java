package com.leon.arithmetic.hundred;

/**
  * ClassName:    CanJump
  * @Description: 55
  * @Author:      liyang
  * @Date:        2021/6/15
  * version     1.0.0
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int r= 0;
        for (int i = 0; i < length; i++) {
            if (i <= r){
                r= Math.max(r,i+nums[i]);
                if (r>=length-1) return true;
            }
        }
        return false;
    }


    public int jump(int[] nums){
        int len = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < len-1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i==end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}