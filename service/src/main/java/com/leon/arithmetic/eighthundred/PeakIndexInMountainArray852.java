package com.leon.arithmetic.eighthundred;

/**
  * ClassName:    PeakIndexInMountainArray852
  * @Description: 852. 山峰数组峰顶
  * @Author:      liyang
  * @Date:        2021/11/18
  * version     1.0.0
 */
public class PeakIndexInMountainArray852 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0,right = arr.length-1;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (arr[mid]<arr[mid+1]){
                left = mid+1;
            }else {
                right = mid;
            }

            /*  优化↑↑↑↑↑
            if (arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]){
                return mid;
            }else if (arr[mid]<arr[mid-1]){//中位数落在\右半山峰
                right = mid;
            }else {
                left = mid+1;
            }*/
        }
        return left;
    }
}