package com.leon.arithmetic.hundred;

/**
  * ClassName:    SearchRotateNum
  * @Description: 33
  * @Author:      liyang
  * @Date:        2021/5/14
  * version     1.0.0
 */
public class SearchRotateNum {


    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length -1;

        while (l <= r){
            int mid = (l + r) >> 1;
            if (target == nums[mid]) return mid;

            if (nums[l] <= nums[mid]){
                if (target >= nums[l] && target < nums[mid])
                    r = mid-1;
                else
                    l = mid+1;
            }else{
                if (target > nums[mid] && target <= nums[r])
                    l = mid +1;
                else
                    r = mid -1;
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1,ret=-1;
        while (left<right){
            int mid = (left+right)/2;





            //旋转点在左
            if (nums[mid]<nums[left]){
                if (target<=nums[right]&&nums[mid]<=target){
                    if (nums[right] == target) return right;
                    left = mid;
                }else {
                    right = mid;
                }
            }else if (nums[mid]>nums[right]){
                if (nums[left]<=target&&nums[mid]>=target){
                    if (nums[left] == target) return left;
                    right = mid;
                }else {
                    left = mid+1;
                }
            }else {
                if (nums[mid]>target){
                    right = mid;
                }else if (nums[mid]==target){
                    return mid;
                }else {
                    left = mid+1;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args){
        SearchRotateNum searchRotateNum = new SearchRotateNum();
        searchRotateNum.search(new int[]{4,5,6,7,0,1,2},3);
    }
}