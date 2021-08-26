package com.leon.arithmetic.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
  * ClassName:    GetLeastNumbers
  * @Description: 40
  * @Author:      liyang
  * @Date:        2021/4/16
  * version     1.0.0
 */
public class GetLeastNumbers {
    // 快排
    public static int[] getLeastNumbers(int[] arr, int k) {
//        ArrayList<Integer> ret = new ArrayList<>();
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int[] ret = quickSearch(arr, 0, arr.length - 1, k - 1);
        System.out.println(ret[k-1]);
        return ret;
    }

    /**
     *
     * @param arr
     * @param s 起始index
     * @param e 结束inde
     * @param k 传过来是k-1，所以是第K个数
     * @return
     */
    private static int[] quickSearch(int[] arr,int s,int e, int k){
        int j = partition(arr, s, e);
        if (j==k){
            return Arrays.copyOf(arr,j+1);
        }
        return j>k?quickSearch(arr,s,j-1,k):quickSearch(arr,j+1,e,k);
    }

    /**
     * 分出第一个数所处位置，大于移到后面，小于移到前面
     * @param arr
     * @param s
     * @param e
     * @return
     */
    private static int partition(int[] arr, int s,int e){
        int v = arr[s];
        int i = s+1, j = e;
        while (true) {
            // 左index如果小于结束index并且值小于中值v,加加
            while (i <= e && arr[i] < v) i++;
            // 右index如果大于起始index并且值大于中值v,减减
            while (j >= s && arr[j] > v) j--;
            // 如果已经左右相遇，则跳出将起始值赋中值，调换位置
            if (i >= j) {
                break;
            }
            //没有相遇，将ij互换
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
        // 如果已经左右相遇，则跳出将起始值赋中值，调换位置，※由于先右移->，所以最后取值取j
        arr[s] = arr[j];
        arr[j] = v;
        return j;
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        int[] ret = new int[k];
        if (k==0||arr.length==0) return new int[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2-t1;
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (priorityQueue.peek()>arr[i]){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }


    public static void main(String[] args) {
        int [] array = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        getLeastNumbers2(array,24);
        for (int i = 0; i < array.length;i++)
            System.out.print(array[i] + " ");
    }
}