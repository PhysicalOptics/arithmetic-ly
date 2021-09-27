package com.leon.arithmetic.twohundred;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
  * ClassName:    MaxSlidingWindow239
  * @Description: 滑动窗口最大值
  * @Author:      liyang
  * @Date:        2021/9/26
  * version     1.0.0
 */
public class MaxSlidingWindow239 {

    // 大顶堆小顶堆测试，大顶堆【t2-t1】求最小的top，小顶堆【t1-t2】求最大的top
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        priorityQueue.add(23);
        priorityQueue.add(13);
        priorityQueue.add(45);
        priorityQueue.add(24);
        priorityQueue.add(3);
        priorityQueue.poll();
        priorityQueue.add(85);
        priorityQueue.poll();
        for (Integer integer : priorityQueue) {
            System.out.println(integer);
        }

    }

//
// 3
//13
//45
//24
//23
//85
// public int[] maxSlidingWindow2(int[] nums, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer t1, Integer t2) {
//                return t1 - t2;
//            }
//        });
//
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length <k) return null;
        int[] ret = new int[length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            // 如果最后一个小于新来的，则去除最后一个
            while (queue.size()>0 && nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            // 如果窗口满了,去除第一个
            if (i-queue.peekFirst()==k){
                queue.pollFirst();
            }
            if (i >= k - 1){
                ret[i-k+1]=nums[queue.peekFirst()];
            }
        }
        return ret;
    }
}