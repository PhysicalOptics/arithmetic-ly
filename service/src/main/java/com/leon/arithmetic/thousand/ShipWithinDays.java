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
    public static void main(String[] args){
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        shipWithinDays.shipWithinDays(new int[]{1,2,3,1,1},4);
    }

    public int shipWithinDays2(int[] weights, int D) {
        int left = weights[weights.length-1];
//        int right = 0;
//        for (int weight : weights) {
//            right += weight;
//        }

//        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left<right){
            int mid = left+(right-left)/2;
            if (canTrans(weights,mid,D)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public boolean canTrans(int[] weights,int cap,int D){
        int cur = 0,transDay = 1;
        for (int weight : weights) {
            if (weight>cap) return false;
            if (cur+weight>cap){
                transDay++;
                cur = weight;
            }else {
                cur += weight;
            }

//            if (cur+weight>cap){
//                transDay++;
//                cur = 0;
//            }
//            cur+=weight;

            if (transDay>D) return false;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = weights[0],right = 0;
        for (int i : weights) {
            right += i;
            left = Math.max(i, left);
        }
        while (left < right){
            // 假设一天运载量为总和和最大值中值
            int mid = left + (right-left) / 2;
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