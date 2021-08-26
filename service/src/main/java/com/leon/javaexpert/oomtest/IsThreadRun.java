package com.leon.javaexpert.oomtest;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
  * ClassName:    IsThreadRun
  * @Description: 发生OOM其他线程是否会继续执行
  * @Author:      liyang
  * @Date:        2021/8/4
  * version     1.0.0
 */
public class IsThreadRun {
    static ArrayList<byte[]> bytes = new ArrayList<>();

//    static String by= "1asdfqwrcsdfsadfwqerwerwqerwre23";
//    public static void main(String[] args){
//        while (true){
//            by = by+by+UUID.randomUUID();
//            System.out.println(LocalDateTime.now());
//            try {
//                TimeUnit.SECONDS.sleep(1L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    OOM
    public static void main(String[] args){
        try {
            TimeUnit.SECONDS.sleep(18);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            while (true){
                bytes.add(new byte[1024*256]);
                System.out.println(LocalDateTime.now());
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AAAA").start();

//        new Thread(()->{
//            int count = 1;
//            while (true){
//                System.out.println(Thread.currentThread().getName()+count);
//                count++;
//                // 扩展静态的list被其他线程用到的话
//                if (count==18) bytes.add(new byte[1024*218]);
//                try {
//                    TimeUnit.SECONDS.sleep(1L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"BBBB").start();


    }


//    public static void main(String[] args) {
//        System.out.println(UUID.randomUUID());
//        String str = "leon";
//        int i= 1;
//        try {
//            TimeUnit.SECONDS.sleep(15L);
//            new Thread(()->{
//
//                ArrayList<String> list = new ArrayList<>();
//                while (true){
//
//                    for (int j = 0; j < 30; j++) {
//                        String temp = UUID.randomUUID().toString();
//                        for (int x = 0; x < 80; x++) {
//                            temp += UUID.randomUUID().toString();
//                        }
//                        String a = new String(str+new Random(10000000).nextInt(1000000000)+temp +i+new Random(10000000).nextInt(1000000000));
//                        list.add(a);
//                    }
//
//                    System.out.println(LocalDateTime.now());
//                    try {
//                        TimeUnit.SECONDS.sleep(1L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            },"AAAA").start();
//
//
//            new Thread(()->{
//                int count = 1;
//                while (true){
//                    System.out.println(Thread.currentThread().getName()+count);
//                    count++;
//                    try {
//                        TimeUnit.SECONDS.sleep(1L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            },"BBBB").start();
//
//        } catch (InterruptedException e) {
//            System.out.println("IsThreadRun 异常了");
//            e.printStackTrace();
//        }
//    }
}