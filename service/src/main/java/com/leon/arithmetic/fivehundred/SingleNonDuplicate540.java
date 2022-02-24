package com.leon.arithmetic.fivehundred;

/**
  * ClassName:    SingleNonDuplicate540
  * @Description: 540. 返回非重复的数
  * @Author:      liyang
  * @Date:        2022/2/14
  * version     1.0.0
 */
public class SingleNonDuplicate540 {

    public static void main(String[] args){
        int[] n = {1,1,3,3,4};
        SingleNonDuplicate540 singleNonDuplicate540 = new SingleNonDuplicate540();
        singleNonDuplicate540.singleNonDuplicate(n);
    }
    
    public int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (mid%2==0){
                if (mid+1<nums.length && nums[mid]==nums[mid+1]){
                    left = mid+2;
                }else {
                    right = mid;
                }
            }else {
                if (mid-1>=0 && nums[mid]==nums[mid-1]){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }
        }
        return nums[left];
        //int ret = nums[0];
        //for (int i = 1; i < nums.length; i++) {
        //    ret = ret^nums[i];
        //}
        //return ret;
    }
}