package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    SearchMatrix
  * @Description: 74
  * @Author:      liyang
  * @Date:        2021/3/30
  * version     1.0.0
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int a = matrix.length;
        int b = matrix[0].length;
        int l = 0,r=a*b-1;
        while (l<=r){
            int mid= (l+r)/2;
            int x= matrix[mid/b][mid%b];
            if (target<x){
                r=mid-1;
            }else if (target>x){
                l=mid+1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] ints = {{1, 3, 5, 7}, {10, 11, 16, 18}, {21, 23, 25, 27}};
        searchMatrix(ints,3);
    }

}