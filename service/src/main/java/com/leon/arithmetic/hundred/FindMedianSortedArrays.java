package com.leon.arithmetic.hundred;

/**
  * ClassName:    FindMedianSortedArrays
  * @Description: 4
  * @Author:      liyang
  * @Date:        2021/3/22
  * version     1.0.0
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double inter1=0,inter2=0;
        double ret;
        if (nums1.length>0){
            int i = (nums1.length-1) / 2;
            int j = (nums1.length-1) % 2;
            inter1 = ((double)(nums1[i]+nums1[i+j]))/2;
        }
        if (nums2.length>0){
            int i = (nums2.length-1) / 2;
            int j = (nums2.length-1) % 2;
            inter2 = ((double)(nums2[i]+nums2[i+j]))/2;
        }
        if (nums1.length<1){
            ret = inter2;
            return ret;
        }
        if (nums2.length<1){
            ret = inter1;
            return ret;
        }

        return (inter1+inter2)/2;
    }

    public static void main(String[] args){
//        System.out.println((null+23D)/2);
    }


}