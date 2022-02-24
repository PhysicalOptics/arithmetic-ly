package com.leon.arithmetic.twohundred;

import io.netty.util.HashedWheelTimer;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadFactory;

/**
  * ClassName:    RangeBitwiseAnd201
  * @Description: 201. 数字范围按位与
  * @Author:      liyang
  * @Date:        2021/12/7
  * version     1.0.0
 */
public class RangeBitwiseAnd201 {

    public static void main(String[] args){
        HashedWheelTimer w = new HashedWheelTimer();

        System.out.println(2147483646&2147483647);
    }
    public int rangeBitwiseAnd(int left, int right) {
        int ret = left;
        if (ret==Integer.MAX_VALUE) return ret;
        for (int i = left+1; i <= right; i++) {
            ret = ret&i;
            if (ret == 0) return ret;
            if (i==Integer.MAX_VALUE) break;
        }
        return ret;
    }

}