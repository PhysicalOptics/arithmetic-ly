package com.leon.arithmetic.thousand;

/**
  * ClassName:    MiddleNum
  * @Description: 35
  * @Author:      liyang
  * @Date:        2021/3/5
  * version     1.0.0
 */
public class MiddleNum {
    public int countTriplets(int[] arr) {
        int length = arr.length;
        if (length<2) return 0;
        int i=0;
        int ret = 0;
        while (i< length-1){
            int j = i+1;
            while (j<length){
                int ans = 0;
                for (int k = i; k <= j; k++) {
                    ans ^= arr[k];
                }
                if (ans == 0) ret++;
                j++;
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args){
        MiddleNum middleNum = new MiddleNum();
        System.out.println(middleNum.countTriplets(new int[]{1,1,1}));
    }
}