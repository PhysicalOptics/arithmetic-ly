package com.leon.arithmetic.thousand;

import java.util.Arrays;

/**
  * ClassName:    ShipWithinDays
  * @Description: 1011
  * @Author:      liyang
  * @Date:        2021/4/27
  * version     1.0.0
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int left = weights[0],right = 0;
        for (int i : weights) {
            right += i;
            left = Math.max(i, left);
        }
        while (left < right){
            // 假设一天运载量为总和和最大值中值
            int mid = (left + right) / 2;
            int need = 1;
            // 当天已经运送货物
            int cur = 0;
            for (int weight : weights) {
                // 当一天的量超过mid，则加一天当天运送货置0
                if (cur+weight>mid){
                    need++;
                    cur = 0;
                }
                cur+=weight;
            }
            if (need<=D){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;

    }


}