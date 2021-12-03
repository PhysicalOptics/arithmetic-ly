package com.leon.arithmetic.fivehundred;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
  * ClassName:    FindRelativeRanks506
  * @Description: 506. 相对名次
  * @Author:      liyang
  * @Date:        2021/12/2
  * version     1.0.0
 */
public class FindRelativeRanks506 {


    public static void main(String[] args){
        int[] ints = {8, 3, 4, 6, 2, 9, 2, 3, 6, 7};
        quickSort(ints,0,ints.length-1);
        System.out.println(ints);
    }

    public static String[] findRelativeRanks(int[] score) {
        String[] medal = {"Gold Medal","Silver Medal","Bronze Medal"};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : score) {
            list.add(i);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2-t1;
            }
        });
        String[] strings = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int index = list.indexOf(score[i]);
            if (index<3){
                strings[i] = medal[index];
            }else {
                strings[i] = (index+1)+"";
            }
        }
        return strings;
    }

    public static void quickSort(int[] arr,int start,int end){
        if (arr==null || arr.length<1) return;
        if (start>=end) return;
        int left = start,right = end;
        int temp = arr[start];
        while (left<right){
            while (left<right&&arr[right]>=temp){
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&arr[left]<=temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;

        if (left-1>start){
            quickSort(arr,start,left-1);
        }
        if (left+1<end){
            quickSort(arr,left+1,end);
        }
    }
}