package com.leon.arithmetic.fourhundred;

import java.util.Arrays;

/**
  * ClassName:    SplitArray
  * @Description: 410
  * @Author:      liyang
  * @Date:        2021/7/16
  * version     1.0.0
 */
public class SplitArray {
    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while (left<right){
            int mid = left+(right-left)/2;
            if (canTrans(nums,mid,m)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public boolean canTrans(int[] weights,int cap,int D){
        int cur = 0,transDay = 1;
        for (int weight : weights) {
            if (weight>cap) return false;
            if (cur+weight>cap){
                transDay++;
                cur = weight;
            }else {
                cur += weight;
            }

            if (transDay>D) return false;
        }
        return true;
    }

}