package com.leon.arithmetic.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
  * ClassName:    ThreeSum
  * @Description: 15
  * @Author:      liyang
  * @Date:        2021/3/12
  * version     1.0.0
 */
public class ThreeSum {

    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((t1, t2) -> t1.compareTo(t2));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,10,30,TimeUnit.SECONDS,new LinkedBlockingDeque<>(23),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());
        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            // 如果三个数里最小数都大于0则后面则无解
            if(nums[i] > 0) return lists;
            // 如果重复数连着则跳过
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    // 对重复数处理
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }


}