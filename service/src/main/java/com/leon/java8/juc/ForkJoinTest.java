package com.leon.java8.juc;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
  * ClassName:    ForkJoinTest
  * @Description: FJ测试
  * @Author:      liyang
  * @Date:        2021/8/11
  * version     1.0.0
 */
public class ForkJoinTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0L, 100000L);
//        forkJoinPool.execute(forkJoinDemo);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        submit.get();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.signal();

    }
}