package com.leon.arithmetic.thousand;

/**
  * ClassName:    LongestOnes
  * @Description: 1004
  * @Author:      liyang
  * @Date:        2021/2/19
  * version     1.0.0
 */
public class LongestOnes {
    public static int longestOnes(int[] A, int K) {
        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r++] == 0) K--;
            if (K < 0 && A[l++] == 0) K++;
        }
        return r - l;

        /*int ret = 0,left=0,right=0,zeros=0;
        while (right<A.length){
            if (A[right]==0){
                zeros++;
            }
            while (zeros>K){
                if (A[left]==0) zeros--;
                left++;
            }
            ret = Math.max(ret,right-left+1);
            right++;
        }
        return ret;*/
    }

    public static void main(String[] args){
        int[] ints = {0, 1, 0, 0, 1, 1, 1, 0, 0,0,0,0,0};
        System.out.println(longestOnes(ints,2));
    }
}