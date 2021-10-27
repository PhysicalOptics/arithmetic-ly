package com.leon.arithmetic.offer;

/**
  * ClassName:    PeakIndexInMountainArray69
  * @Description: 69. 山峰数组的顶部
  * @Author:      liyang
  * @Date:        2021/10/14
  * version     1.0.0
 */
public class PeakIndexInMountainArray69 {

    public static void main(String[] args){
        PeakIndexInMountainArray69 array69 = new PeakIndexInMountainArray69();
        array69.peakIndexInMountainArray2(new int[]{1,2,3,5,6,2,1});
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            // 当中位数大于左侧时，直接left跳到mid
            if (arr[mid - 1] < arr[mid]) l = mid;
            // 当中位数已经是顶点的时候不可能走到这，在上一步已经处理了，所以到这的时候一定处于右侧下降且不可能是顶点
            else r = mid - 1;
        }
        return r;
    }


    public int peakIndexInMountainArray(int[] arr) {
        int left = 0 ,right = arr.length;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]){
                return mid;
            }else if (arr[mid+1]>arr[mid]&&arr[mid]>arr[mid-1]){
                left = mid+1;
            }else if (arr[mid+1]<arr[mid]&&arr[mid]<arr[mid-1]){
                right = mid;
            }
        }
        return left;
    }
}