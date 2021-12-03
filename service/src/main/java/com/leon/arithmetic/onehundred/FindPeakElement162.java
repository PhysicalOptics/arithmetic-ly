package com.leon.arithmetic.onehundred;

/**
  * ClassName:    FindPeakElement162
  * @Description: 162. 寻找峰值
  * @Author:      liyang
  * @Date:        2021/11/23
  * version     1.0.0
 */
public class FindPeakElement162 {

    public static void main(String[] args){
        int peakElement = findPeakElement(new int[]{1, 2, 3, 1});
        System.out.println(peakElement);
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length==1) return 0;
        if (nums[0]>nums[1]) return 0;
        if (nums[nums.length-1]>nums[nums.length-2])return nums.length-1;
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return nums[mid];
            }else if (nums[mid]>nums[mid+1]){
                right = mid;
            }else if (nums[mid]<nums[mid+1]){
                left = mid+1;
            }
        }
        return left;
    }
}