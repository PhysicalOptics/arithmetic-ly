package com.leon.arithmetic.threehundred;

import java.util.HashMap;

/**
  * ClassName:    LengthOfLIS300
  * @Description: 300. 最长递增子序列
  * @Author:      liyang
  * @Date:        2021/12/28
  * version     1.0.0
 */
public class LengthOfLIS300 {

    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        if (map.get("3")==3){
            System.out.println(111);
        }
        System.out.println(222);
    }

    // 动态规划
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i <nums.length ; i++) {
            // 在自己位置范围内，从0开始比对，最大的有序长度
            for (int j = 0; j < i; j++) {
                //如果大于，则记dp[j]+1,一个个对比，最后得到最大长度
                if (nums[i]>=nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                }
            }
        }

        return max;
    }


    // 窗口
    public static int lengthOfLIS2(int[] nums) {
        int length = nums.length;
        if (length < 2) return length;
        int[] tails = new int[length];
        tails[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果当前数大于tail的尾巴
            if (nums[i] > tails[res]) {
                //则将当前数加入tail
                res++;
                tails[res] = nums[i];
            } else {
                // 如果比尾巴小，则寻找自己的位置替换比自己大的那个数
                //二分寻找
                int l = 0, r = res;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (nums[i] > tails[m]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                tails[l] = nums[i];
            }
        }
        res++;
        return res;
    }

}