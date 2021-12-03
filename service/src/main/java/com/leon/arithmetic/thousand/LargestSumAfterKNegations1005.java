package com.leon.arithmetic.thousand;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
  * ClassName:    LargestSumAfterKNegations1005
  * @Description: 1005. k次取反最大和
  * @Author:      liyang
  * @Date:        2021/12/3
  * version     1.0.0
 */
public class LargestSumAfterKNegations1005 {

    public static void main(String[] args){
        int i = largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
        System.out.println(i);
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)-> nums[a]-nums[b]);
        int minIndex = 0;
        // 找出最小数，以及将所有负数放入最小队列
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                priorityQueue.offer(i);
            }
            if (Math.abs(nums[i])<Math.abs(nums[minIndex])) minIndex = i;
        }

        // 如果改变次数小于负数个数，则改变最小的那k个负数
        if (k<priorityQueue.size()){
            while (k>0){
                Integer poll = priorityQueue.poll();
                nums[poll] = -nums[poll];
                k--;
            }
        }else {// 改变次数大于负数个数，如果改变完负数，{还是2的倍数则不动，如果是奇数则将最小的那个数改为负数}
            while (priorityQueue.size()>0){
                Integer poll = priorityQueue.poll();
                nums[poll] = -nums[poll];
                k--;
            }
            if (k%2>0) nums[minIndex] = -nums[minIndex];
        }
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    // 利用num的取值范围只在+-100之间，利用数组bitmap
    public static int largestSumAfterKNegations2(int[] nums, int k) {
        int[] ints = new int[201];
        for (int num : nums) {
            ints[100+num]++;
        }
        // 将所有的负数从最小开始改变K个
        for (int i = -100; i <0&&k>0 ; i++) {
            while (ints[i+100]!=0&&k>0){
                ints[100+i]--;ints[100-i]++;
                k--;
            }
        }

        if (k%2>0){
            int min = 0;
            while (ints[100+min]==0) min++;
            ints[min+100]--;ints[100-min]++;
        }

        int sum = 0;
        for (int i = -100; i < 101; i++) {
            sum += i*ints[i+100];
        }
        return sum;


    }

}