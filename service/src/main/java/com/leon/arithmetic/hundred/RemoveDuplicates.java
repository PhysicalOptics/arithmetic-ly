package com.leon.arithmetic.hundred;

/**
  * ClassName:    RemoveDuplicates
  * @Description: 80
  * @Author:      liyang
  * @Date:        2021/4/8
  * version     1.0.0
 */
public class RemoveDuplicates {

    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        if (length <3) return length;
        int pre1=2;
        for (int i = 2; i< length; i++) {
            if (nums[i]!=nums[pre1-2]){
                nums[pre1] = nums[i];
                pre1++;
            }
        }
        return pre1+1;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i]!=nums[j]){
                 i++;
                 nums[i] = nums[j];
            }
        }
        return i+1;
    }
}