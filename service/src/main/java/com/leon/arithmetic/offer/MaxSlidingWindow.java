package com.leon.arithmetic.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
  * ClassName:    MaxSlidingWindow
  * @Description: 59
  * @Author:      liyang
  * @Date:        2021/6/23
  * version     1.0.0
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0) return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        int[] ret = new int[length - k + 1];
        for(int i = 0; i < k; i++) {
            while(!queue.isEmpty() && queue.peekLast() < nums[i])
                queue.removeLast();
            queue.addLast(nums[i]);
        }
        ret[0] = queue.peekFirst();
        for (int i = 1; i < length-k+1; i++) {
            int j = i+k-1;
            if (queue.peekFirst()==nums[i-1]) queue.removeFirst();
            while (!queue.isEmpty() && queue.peekLast()<nums[j]){
                queue.removeLast();
            }
            queue.addLast(nums[j]);
            ret[i] = queue.peekFirst();
        }
        return ret;
    }
}