package com.leon.arithmetic.onehundred;

import java.util.Arrays;

/**
  * ClassName:    LargestNumber
  * @Description: 179
  * @Author:      liyang
  * @Date:        2021/4/12
  * version     1.0.0
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        if (length<2) return nums[0]+"";
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr,(x,y)->{
            int t1 = 10, t2 = 10;
            while (t1 <= x){
                t1 *= 10;
            }
            while (t2 <= y){
                t2 *= 10;
            }
            return t1*y+x-t2*x-y;
        });
        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();


    }
}