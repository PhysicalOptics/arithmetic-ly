package com.leon.arithmetic.hundred;

/**
  * ClassName:    MaxArea
  * @Description: 11
  * @Author:      liyang
  * @Date:        2021/5/12
  * version     1.0.0
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,sum = 0;
        while (i<j){
            if (height[i]>height[j]){
                sum = Math.max(sum,height[j]*(j-i));
                j--;
            }else {
                sum = Math.max(sum,height[i]*(j-i));
                i++;
            }
        }
        return sum;
    }
}