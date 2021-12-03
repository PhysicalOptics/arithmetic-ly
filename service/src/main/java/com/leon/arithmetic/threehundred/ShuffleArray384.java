package com.leon.arithmetic.threehundred;

import java.util.ArrayList;
import java.util.Random;

/**
  * ClassName:    ShuffleArray384
  * @Description: 384. 打乱数组
  * @Author:      liyang
  * @Date:        2021/11/22
  * version     1.0.0
 */
public class ShuffleArray384 {
    public static void main(String[] args){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(3));
        }

    }
}

class Solution{
    int[] curr;
    public Solution(int[] nums) {
        this.curr= nums;

    }

    public int[] reset() {
        return curr;
    }

    public int[] shuffle() {
        Random random = new Random();
        int length = curr.length;
        int[] ret = new int[length];
        System.arraycopy(curr, 0, ret, 0, curr.length);
        for (int i = 0; i < length; i++) {
            int j = i + random.nextInt(length - i);
            int temp = ret[i];
            ret[i] = ret[j];
            ret[j] = temp;
        }
        return ret;
    }
}