package com.leon.arithmetic.onehundred;

import java.util.Arrays;

/**
  * ClassName:    Rotate189
  * @Description: 旋转数组
  * @Author:      liyang
  * @Date:        2021/10/18
  * version     1.0.0
 */
public class Rotate189 {
    //法二翻转,
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    //法一
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] ret = new int[length];
        for (int i = 0; i < length; i++) {
            ret[(i+k)%length] = nums[i];
        }
        System.arraycopy(ret,0,nums,0,length);
    }
}