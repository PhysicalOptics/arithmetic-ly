package com.leon.arithmetic.hundred;

/**
  * ClassName:    RemoveElement
  * @Description: 27
  * @Author:      liyang
  * @Date:        2021/4/19
  * version     1.0.0
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int r = 0;
        int l = nums.length;
        for (int i = 0; i+r < l; i++) {
            while (i+r < l && val==nums[i+r]){
                r++;
            }
            if(i+r<l){
                nums[i]=nums[i+r];
            }
        }
        return l-r;
    }

}