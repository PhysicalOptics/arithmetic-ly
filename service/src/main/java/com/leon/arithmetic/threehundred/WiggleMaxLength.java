package com.leon.arithmetic.threehundred;

/**
  * ClassName:    WiggleMaxLength
  * @Description: 376
  * @Author:      liyang
  * @Date:        2021/7/2
  * version     1.0.0
 *
 * 1,2,9,7,18,12,13,3
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
    public static void main(String[] args){
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        int length = wiggleMaxLength.wiggleMaxLength(new int[]{1,2,9,7,18,12,13,3});
        System.out.println(length);
    }
}