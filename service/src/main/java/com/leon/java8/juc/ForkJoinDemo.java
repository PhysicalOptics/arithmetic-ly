package com.leon.java8.juc;

import java.util.concurrent.RecursiveTask;

/**
  * ClassName:    ForkJoinDemo
  * @Description: forkjoin
  * @Author:      liyang
  * @Date:        2021/8/11
  * version     1.0.0
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    private Long temp=1000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end-start<temp){
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }else {
            long mid = start+(end-start)/2;
            ForkJoinDemo fork1 = new ForkJoinDemo(start, mid);
            fork1.fork();
            ForkJoinDemo fork2 = new ForkJoinDemo(mid, end);
            fork2.fork();
            return fork1.join()+fork2.join();
        }

    }
}