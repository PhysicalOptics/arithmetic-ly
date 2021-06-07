package com.leon.arithmetic.sort;

/**
  * ClassName:    QuickSort
  * @Description: 快排
  * @Author:      liyang
  * @Date:        2020/12/24
  * version     1.0.0
 */
public class QuickSort {
    public static void quickSort(int[] array, int start, int end) {
        int i = start, j = end;
        int target = array[start];
        while (i < j) {
            while (i < j && target <= array[j])
                j--;
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            while (i < j && array[i] <= target)
                i++;
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        if (i - 1 > start){
            quickSort(array, start, i - 1);
        }

        if (j + 1 < end){
            quickSort(array,j + 1, end);
        }
    }

    private static void QKSourt(int[] a, int start, int end) {
        if (a.length < 0){
            return ;
        }
        if (start >= end){
            return ;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right){
            while (left < right && a[right] >= temp){
                right -- ;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp){
                left ++ ;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        if (start<left-1){
            QKSourt(a, start, left -1);
        }
        if (left+1<end){
            QKSourt(a,left+1,end);
        }
    }


    public static void main(String[] args) {
        int [] array = {1,2,3,4};
        QKSourt(array,0,array.length - 1);
        for (int i = 0; i < array.length;i++)
            System.out.print(array[i] + " ");
    }
}