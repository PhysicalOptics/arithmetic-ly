package com.leon.arithmetic.fourhundred;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
  * ClassName:    ThirdMax414
  * @Description: 414、第三大数
  * @Author:      liyang
  * @Date:        2021/10/9
  * version     1.0.0
 */
public class ThirdMax414 {

    public static void main(String[] args){
        ThirdMax414 thirdMax = new ThirdMax414();
        thirdMax.thirdMax2(new int[]{1,2,-2147483648});
    }

    // 不重复第三大无法解决
     public int thirdMax(int[] nums) {

         int max=nums[0];

         PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
             @Override
             public int compare(Integer t1, Integer t2) {
                 return t1-t2;
             }
         });
         ArrayList<Integer> list = new ArrayList<>();
         for (int i = 0; i < nums.length; i++) {
             if (!list.contains(nums[i])){
                 if (priorityQueue.size()<3){
                     priorityQueue.offer(nums[i]);
                     list.add(nums[i]);
                 }else if (priorityQueue.peek()<nums[i]){
                     priorityQueue.offer(nums[i]);
                     list.add(nums[i]);
                     priorityQueue.poll();
                 }
             }

         }
         int size = priorityQueue.size();
         if (size<3){
             for (int i = 0; i < size; i++) {
                 max = Math.max(max, priorityQueue.poll());
             }
             return max;
         }
         max = priorityQueue.peek();

         return max;
     }


    public int thirdMax2(int[] nums) {
        int max = nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1-t2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            if (pq.size() < 3 && !pq.contains(nums[i])){
                pq.offer(nums[i]);
            }else {
                if (pq.peek() < nums[i]  && !pq.contains(nums[i])){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        if (pq.size() < 3){
            return max;
        }
        return pq.peek();
    }
}