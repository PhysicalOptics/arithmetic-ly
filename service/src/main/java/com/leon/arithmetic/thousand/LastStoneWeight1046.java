package com.leon.arithmetic.thousand;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
  * ClassName:    LastStoneWeight1046
  * @Description: 1046. 最后一块石头的重量
  * @Author:      liyang
  * @Date:        2022/2/23
  * version     1.0.0
 */
public class LastStoneWeight1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        for (int stone : stones) {
           queue.offer(stone);
        }
        while (queue.size()>1){
            Integer max = queue.poll();
            Integer max2 = queue.poll();
            if (max!=max2) queue.offer(max-max2);
        }
        return queue.isEmpty()?0:queue.poll();

    }

}