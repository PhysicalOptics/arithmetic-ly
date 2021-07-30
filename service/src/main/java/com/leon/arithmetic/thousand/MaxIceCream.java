package com.leon.arithmetic.thousand;

import java.util.Arrays;

/**
  * ClassName:    MaxIceCream
  * @Description: 1833
  * @Author:      liyang
  * @Date:        2021/7/2
  * version     1.0.0
 */
public class MaxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        for (int i = 0; i < costs.length; i++) {
            coins = coins-costs[i];
            if (coins<0) return i;
        }
        return 0;
    }
}