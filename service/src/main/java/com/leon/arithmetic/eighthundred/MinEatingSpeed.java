package com.leon.arithmetic.eighthundred;

import java.util.Arrays;

/**
  * ClassName:    MinEatingSpeed
  * @Description: 875
  * @Author:      liyang
  * @Date:        2021/7/19
  * version     1.0.0
 */
public class MinEatingSpeed {
    public static void main(String[] args){
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        minEatingSpeed.minEatingSpeed(new int[]{3,6,7,11},8);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left<right){
            int mid = left+(right-left)/2;
            if (canFinishEat(piles,h,mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public boolean canFinishEat(int[] piles, int h, int eat){
        int cur=0;
        for (int pile : piles) {
            cur += pile / eat + ((pile%eat)>0?1:0);
            if (cur>h) return false;
        }
        return true;
    }
}