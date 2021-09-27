package com.leon.arithmetic.hot100;

/**
  * ClassName:    Trap42
  * @Description: 接雨水42
  * @Author:      liyang
  * @Date:        2021/9/27
  * version     1.0.0
 */
public class Trap42 {

    public int trap(int[] height) {
        int length = height.length;
        if (length<3) return 0;
        int left = 0,right = length-1;
        int leftMax = 0,rightMax = 0;
        int sum = 0;

        while (left<right){
            if (height[left]<height[right]){
                if (height[left]>=leftMax){
                    leftMax = height[left];
                }else {
                    sum+= leftMax-height[left];
                }
                left++;
            }else {
                if (height[right]>=rightMax){
                    rightMax = height[right];
                }else {
                    sum += rightMax-height[right];
                }
                right--;

            }
        }
        return sum;
    }
}