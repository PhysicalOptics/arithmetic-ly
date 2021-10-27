package com.leon.arithmetic.ninehundred;

/**
  * ClassName:    Ninehundred977
  * @Description: 977. 有序数组的平方
  * @Author:      liyang
  * @Date:        2021/10/18
  * version     1.0.0
 */
public class Ninehundred977 {

    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] ret = new int[length];
        int left = 0 ,right = length-1,pos=length-1;
        while (left<=right){
            if (nums[left]*nums[left] >= nums[right]*nums[right]){
                ret[pos] = nums[left]*nums[left];
                left++;
            }else {
                ret[pos] = nums[right]*nums[right];
                right--;
            }
            pos--;
        }
        return ret;
    }

}