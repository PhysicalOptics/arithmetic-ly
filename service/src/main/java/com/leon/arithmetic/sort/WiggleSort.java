package com.leon.arithmetic.sort;

import java.util.Arrays;

/**
  * ClassName:    WiggleSort
  * @Description: 摇摆排序
  * @Author:      liyang
  * @Date:        2020/12/24
  * version     1.0.0
 */
public class WiggleSort {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        System.arraycopy(nums,0,result,0,result.length);
        int mo = nums.length % 2;
        int d = nums.length / 2;
        for (int i = d-1; i >= 0; i--) {
            nums[2*(d-1-i)]=result[i+mo];
            nums[2*(d-1-i)+1]=result[d+i+mo];
        }
        if (mo==1) nums[nums.length-1] = result[0];
    }
    //[5,3,1,2,6,7,8,5,5]
    public static void main(String[] args){
        int[] p = {5,3,1,2,6,7,8,5,5};
        wiggleSort(p);
    }
}