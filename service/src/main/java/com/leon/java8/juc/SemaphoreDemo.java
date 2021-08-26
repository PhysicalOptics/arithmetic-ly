package com.leon.java8.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
  * ClassName:    SemaphoreDemo
  * @Description: 信号量
  * @Author:      liyang
  * @Date:        2021/8/11
  * version     1.0.0
 */
public class SemaphoreDemo {

    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开了车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },i+"").start();
        }

    }
}