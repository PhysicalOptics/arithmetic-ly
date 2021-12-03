package com.leon.arithmetic.hundred;

/**
  * ClassName:    Search33
  * @Description: 33. 搜索旋转排序
  * @Author:      liyang
  * @Date:        2021/11/17
  * version     1.0.0
 */
public class Search33 {

    public static void main(String[] args){
        Search33 search33 = new Search33();
        search33.search(new int[]{4,5,6,7,0,1,2},0);
    }

    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = left + (right - left) / 2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[left] <= nums[mid]){ //如果【中位线】落在左半递增
                 if (nums[left]<=target&&nums[mid]>target){//如果【目标值】也在左半区，则右边界收缩为mid
                    right = mid-1;
                 }else {
                    left = mid+1;
                 }
            }else {// 如果中位线落在右半递增
                if (nums[right]>=target&&nums[mid]<target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}