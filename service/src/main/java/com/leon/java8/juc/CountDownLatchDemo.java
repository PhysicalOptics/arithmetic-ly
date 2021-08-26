package com.leon.java8.juc;

import java.util.concurrent.CountDownLatch;

/**
  * ClassName:    CountDownLatchDemo
  * @Description: 减法计数器
  * @Author:      liyang
  * @Date:        2021/8/11
  * version     1.0.0
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go Out");
                countDownLatch.countDown();
            },i+"").start();
        }
        // 当计数器都归零后才继续执行，否则等待
        countDownLatch.await();

        System.out.println("Close Door");
    }
    
}