package com.leon.arithmetic.sort;

/**
  * ClassName:    QuickSort
  * @Description: 快排
  * @Author:      liyang
  * @Date:        2020/12/24
  * version     1.0.0
 */
public class QuickSortTest {


    public static void quickSort(int[] array, int start, int end) {
        if (array.length<=1 || start == end){
            return;
        }
        int left= start,right =end;
        int temp = array[start];
        while (start<end){
            while (start<end && temp<=array[end]){
                end--;
            }
            array[start] = array[end];
//            array[end] = temp;
            while (start<end && temp>=array[start]){
                start++;
            }
            array[end] = array[start];
//            array[start] = temp;
        }
        array[start]=temp;
        if (left<start-1){
            quickSort(array,left,start-1);
        }
        if (right>end+1){
            quickSort(array,end+1,right);
        }

    }


    public static void main(String[] args) {
        int [] array = {5,2,3,1,6,4,0};
        quickSort(array,0,array.length - 1);
        for (int i = 0; i < array.length;i++)
            System.out.print(array[i] + " ");
    }
}