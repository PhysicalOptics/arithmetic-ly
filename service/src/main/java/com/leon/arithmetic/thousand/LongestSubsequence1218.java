package com.leon.arithmetic.thousand;

import java.util.HashMap;

/**
  * ClassName:    LongestSubsequence1218
  * @Description: 1218. 最长定差子序列
  * @Author:      liyang
  * @Date:        2021/11/5
  * version     1.0.0
 */
public class LongestSubsequence1218 {
    public static void main(String[] args){
        int i = longestSubsequence2(new int[]{1,5,7,8,5,3,4,2,1},-2);
        System.out.println(i);
    }

    public static int longestSubsequence2(int[] arr, int difference) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            map.put(v,map.getOrDefault(v-difference,0)+1);
            max = Math.max(max, map.get(v));
        }
        return max;
    }

    public static int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i];
            int tempmax = 1;
            int j = i+1;
            start += difference;
            while (j<arr.length){
                if (start == arr[j]){
                    tempmax++;
                    start += difference;
                }
                j++;
            }
            max = Math.max(max,tempmax);
        }
        return max;
    }
}