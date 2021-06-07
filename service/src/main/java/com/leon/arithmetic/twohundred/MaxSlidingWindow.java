package com.leon.arithmetic.twohundred;

import java.util.Deque;
import java.util.LinkedList;

/**
  * ClassName:    MaxSlidingWindow
  * @Description: 239
  * @Author:      liyang
  * @Date:        2021/2/20
  * version     1.0.0
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length<k || k<1){
            return null;
        }
        //#1 构建有序队列
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i<nums.length; i++){

            // 如果当前元素大于队列里右侧最小值，则依次清楚小于当前元素值
            while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.addLast(i);
            // 如果窗口滑动超出最左侧值的下标，则剔除超出窗口的值
            if(queue.peekFirst()<(i-k+1)){//如果被窗口抛下了（在窗口左边界的左侧）
                queue.pollFirst();
            }
            // 第一个窗口计数下标k-1
            if(i>=k-1){
                result[index++] = nums[queue.peekFirst()];
            }
        }
        return result;
        /*int[] reInts = new int[nums.length - k + 1];
        int l=0;
        while (l <= nums.length-k){
            int r=l+k-1;
            int max = nums[l];
            for (int i = l; i <= r ; i++) {
                max = nums[i] > max ? nums[i]:max;
            }
            reInts[l] = max;
            l++;
        }
        return reInts;*/
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length-1;
        while (l<r){
            int mid = (l + r) / 2;
            if (arr[mid]<arr[mid+1]){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return r;
        /*int i = arr.length / 2,c=arr.length/2;
        while (arr[i]<arr[i+1] || arr[i]<arr[i-1]){
            c=(c+1)/2;
            if (arr[i]<arr[i+1]){
                i=i+c;
            }else if (arr[i]<arr[i-1]){
                i=i-c;
            }

        }
        return i;*/


//        int lo = 0, hi = A.length - 1;
//        while (lo < hi) {
//            int mi = lo + (hi - lo) / 2;
//            if (A[mi] < A[mi + 1])
//                lo = mi + 1;
//            else
//                hi = mi;
//        }
//        return lo;

    }

    public static void main(String[] args){
        int[] ints = {1,57,58,74,88,93,98,97,96,91,90,78,77,74,71,68,61,50,42,38,35,34,26,20,15,14,5,4,2};
//        System.out.println(2);
//        System.out.println(maxSlidingWindow(ints,3));
        System.out.println(peakIndexInMountainArray(ints));
    }
}