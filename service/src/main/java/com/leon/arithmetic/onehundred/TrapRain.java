package com.leon.arithmetic.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    TrapRain
  * @Description: 42  去除重复数
  * @Author:      liyang
  * @Date:        2021/3/10
  * version     1.0.0
 */
public class TrapRain {
    public int trap(int[] height) {
        if (height.length<3) return 0;
        int sum=0,left=0,right=height.length-1,left_max=0,right_max=0 ;
        while (left<right){
            if (height[left]<=height[right]){
                if (height[left]<=left_max){
                    sum+=left_max-height[left];
                }else{
                    left_max = height[left];
                }
                left++;
            }else {
                if (height[right]<=right_max){
                    sum+=right_max-height[right];
                }else {
                    right_max = height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        if (height.length<3) return 0;
        int l=0,r=height.length-1,sum= 0,l_max=0,r_max=0;
        while (l<r){
            if (height[l]<height[r]){
                if (height[l]<l_max){
                    sum+=l_max-height[l];
                }else {
                    l_max = height[l];
                }
                l++;
            } else {
                if (height[r]<r_max){
                    sum+=r_max-height[r];
                }else {
                    r_max = height[r];
                }
                r--;
            }
        }
        return sum;
    }

    public int[] singleNumbers(int[] nums) {

        // ※关键是组内只有两个唯一值

        int t=0;
        // 所有数异或，得到两个唯一的异或值
        for (int num : nums) {
            t ^=num;
        }
        // 用两个唯一数的异或值，拿到最低位为1
        int less = 1;
        while ((t&less)==0){
            less <<= less;
        }
        // 利用异或值低位为1的特性，将数据分两组，一起异或则得到唯一值
        int a=0,b=0;
        for (int num : nums) {
            if ((less&num)==0){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }

    public int findRepeatNumber(int[] nums) {
        int temp = -1;
        for (int i = 0; i < nums.length; i++) {
            // 循环取找到对应 i 使得归位
            while (nums[i]!= i){
                if (nums[i]== nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrapRain trapRain = new TrapRain();
        System.out.println(trapRain.trap2(ints));
    }
}