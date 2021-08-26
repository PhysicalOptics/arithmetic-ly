package com.leon.java8.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
  * ClassName:    CyclicBarrierDemo
  * @Description: 加法计数器
  * @Author:      liyang
  * @Date:        2021/8/11
  * version     1.0.0
 */
public class CyclicBarrierDemo {

    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("执行召唤神龙成功");
        });

        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集第"+temp+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },i+"").start();
        }

        System.out.println("main 结束");
    }
}