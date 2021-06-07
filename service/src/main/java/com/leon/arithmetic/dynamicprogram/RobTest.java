package com.leon.arithmetic.dynamicprogram;

import java.util.Arrays;

/**
  * ClassName:    RobTest
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/1/14
  * version     1.0.0
 */
public class RobTest {
    public static int rob1(int[] nums) {
        if(nums.length ==0 ) return 0;
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i>=2){
                sum[i] = sum[i-1]>(sum[i-2]+nums[i])?sum[i-1]:(sum[i-2]+nums[i]);
            }else if (i == 1){
                sum[i] = nums[0]>nums[1]?nums[0]:nums[1];
            }else {
                sum[i] = nums[0];
            }
        }
        return sum[nums.length-1];
    }

    public static int rob11(int[] nums){
        if (nums.length==0) return 0;
        int sum = nums[0],pre=0;
        for (int i = 1; i < nums.length ; i++) {
            int cur = sum;
            sum = Math.max(pre+nums[i],sum);
            pre = cur;
        }
        return sum;
    }

    public static int stone(int[] nums){
        if (nums.length==1) return 0;
        int start=0,end=0;
        for (int i = 0; i <nums.length/2 ; i++) {
            start += nums[i];
        }
        for (int i = nums.length/2; i <nums.length ; i++) {
            end += nums[i];
        }
        if (start>end){
            return end+stone(Arrays.copyOfRange(nums,nums.length/2,nums.length));
        }else {
            return start+stone(Arrays.copyOfRange(nums,0,nums.length/2));
        }
    }


    
    public static void main(String[] args){
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(stone(nums));
        System.out.println(rob11(nums));
    }
}