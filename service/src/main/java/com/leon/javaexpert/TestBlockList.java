package com.leon.javaexpert;

import cn.hutool.json.JSONUtil;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
  * ClassName:    TestBlockList
  * @Description: 测试阻塞队列
  * @Author:      liyang
  * @Date:        2021/12/30
  * version     1.0.0
 */
public class TestBlockList {

    final static LinkedBlockingQueue<String> queue =  new LinkedBlockingQueue();
    
    public static void main(String[] args){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            queue.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            try {
                queue.take();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("1"+JSONUtil.toJsonStr(queue));
                String take = queue.take();
                System.out.println(System.currentTimeMillis()+"2"+JSONUtil.toJsonStr(queue));
                Thread.sleep(10000);
                System.out.println(System.currentTimeMillis()+"3"+JSONUtil.toJsonStr(queue));
                TimeUnit.SECONDS.sleep(30);
                System.out.println("3.2"+JSONUtil.toJsonStr(queue));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(6);
                System.out.println("4"+JSONUtil.toJsonStr(queue));
                queue.put("4");
                System.out.println("5"+JSONUtil.toJsonStr(queue));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("6"+JSONUtil.toJsonStr(queue));

    }
}