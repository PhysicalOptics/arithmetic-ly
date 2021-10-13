package com.leon.arithmetic.hundred;

/**
  * ClassName:    SearchRange34
  * @Description: 34. 在排序数组中找到最左最右index
  * @Author:      liyang
  * @Date:        2021/10/11
  * version     1.0.0
 */
public class SearchRange34 {

    public static void main(String[] args){
        SearchRange34 range34 = new SearchRange34();
        range34.searchRange2(new int[]{5,7,7},7);
    }

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length==0) return new int[]{-1,-1};
        int left=0,right=length;
        int fir=-1;
        // 寻找左边界
        while (left<right){
            int mid = left + (right - left) / 2;
            if (nums[mid]==target){
                if (fir<0) fir = mid;
                right = mid;
            }else if (nums[mid]>target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        if (left==length) return new int[]{-1,-1};
        // 也可以再立一个二分找到右边界，left,length
        if (nums[left]==target){
            int end=fir;
            for (int i = fir+1; i < length; i++) {
                if (nums[i]!=target){
                    break;
                }
                end = i;
            }
            return new int[]{left,end};
        }else {
            return new int[]{-1,-1};
        }

    }
    public int[] searchRange2(int[] nums, int target) {
        int length = nums.length;
        if (length==0) return new int[]{-1,-1};
        int left=0,right=length;

        // 寻找左边界
        while (left<right){
            int mid = left + (right - left) / 2;
            if (nums[mid]==target){
                right = mid;
            }else if (nums[mid]>target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        if (left==length || nums[left]!=target) return new int[]{-1,-1};
        // 也可以再立一个二分找到右边界，left,length
        int left2 = left,right2 = length;
        while (left2<right2){
            int mid = left2 + (right2-left2)/2;
            if (nums[mid]==target){
                left2 = mid+1;
            }else if (nums[mid]>target){
                right2 = mid;
            }else {
                left2 = mid+1;
            }
        }
        return new int[]{left,left2-1};


    }
}