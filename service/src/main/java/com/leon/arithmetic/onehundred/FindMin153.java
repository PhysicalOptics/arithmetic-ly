package com.leon.arithmetic.onehundred;

/**
  * ClassName:    FindMin153
  * @Description: 153. 寻找旋转排序最小值
  * @Author:      liyang
  * @Date:        2021/11/18
  * version     1.0.0
 */
public class FindMin153 {

    public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }
}