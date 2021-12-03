package com.leon.arithmetic.sort;

import java.util.Arrays;

/**
  * ClassName:    BubbleSort
  * @Description: 冒泡排序
  * @Author:      liyang
  * @Date:        2021/11/29
  * version     1.0.0
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] ints = bubbleSort(new int[]{6, 3, 9, 4, 1, 2, 5});
        for (int a : ints) {
            System.out.println(a);
        }

    }

    public static int[] bubbleSort(int[] arr){
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                if (arr[i]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}