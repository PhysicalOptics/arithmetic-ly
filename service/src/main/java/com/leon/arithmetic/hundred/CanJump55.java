package com.leon.arithmetic.hundred;

/**
  * ClassName:    CanJump55
  * @Description: 55. 跳跃游戏
  * @Author:      liyang
  * @Date:        2021/12/23
  * version     1.0.0
 */
public class CanJump55 {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int r = 0;
        for (int i = 0; i < length; i++) {
            if (i <= r){
                // 所经过的都能计算是不是最大长度
                r= Math.max(r,i+nums[i]);
                if (r>=length-1) return true;
            }
        }
        return false;

    }
}