package com.leon.arithmetic.twohundred;

import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    MoveZeroes283
  * @Description: 283. 移动0
  * @Author:      liyang
  * @Date:        2021/10/18
  * version     1.0.0
 */
public class MoveZeroes283 {

    public static void main(String[] args){
        MoveZeroes283 zeroes283 = new MoveZeroes283();
        zeroes283.moveZeroes(new int[]{1});
    }

    public void moveZeroes3(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
    public void moveZeroes2(int[] nums) {
        int a= 0,b=0;
        int length = nums.length;
        while (a< length && b<length){
            if (nums[a]!=0){
                a++;
                b++;
            }else if (nums[a]==0){
                while (b<length && nums[b] == 0){
                    b++;
                }
                nums[a] = nums[b];
                nums[b] = 0;
                a++;
                b++;
            }
        }
    }
    // 暴力解法
    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size()>0 && nums[i]!=0){
                Integer index = queue.poll();
                nums[index] = nums[i];
                nums[i] =0;
            }
            if (nums[i]==0){
                queue.offer(i);
            }
        }
    }
}