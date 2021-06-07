package com.leon.arithmetic.threehundred;

import java.util.ArrayList;

/**
  * ClassName:    NumMatrix
  * @Description: 304
  * @Author:      liyang
  * @Date:        2021/3/2
  * version     1.0.0
 */
public class NumMatrix {
    public int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2 ; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public boolean isMonotonic(int[] A) {
        if(A.length>2){
            boolean desc = false,asc = false;
            for (int i = 1; i < A.length; i++) {
                if (A[i]>A[i-1]){
                    asc=true;
                }
                if (A[i]<A[i-1]){
                    desc=true;
                }
                if (asc&&desc)return false;
            }
        }
        return true;
    }

    public int[] countBits(int num) {
        int[] ints = new int[num + 1];
        for (int i = 0; i <= num ; i++) {
            ints[i]=count1(i);
        }
        return ints;
    }

    public static int count1(int num) {
        int c = 0;
        while (num>=1){
            if(num%2!=0){
                c++;
            }
            num = num/2;
        }
        return c;
    }
    public static void main(String[] args){
        long l = 1589731200000L;
        for (int i = 0; i <9 ; i++) {
            l-=604800000L;
            System.out.println(l);
        }
    }
}