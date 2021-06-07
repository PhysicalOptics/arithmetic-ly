package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * ClassName:    SpiralOrder
  * @Description: 54
  * @Author:      liyang
  * @Date:        2021/3/15
  * version     1.0.0
 */
public class SpiralOrder {
    public int[][] spiralOrder2(int n) {
        int length = 0;
        int max = n*n;
        int[][] ret = new int[n][n];
        int left =0,right = n-1,up=0,down = n-1;
        int currrow=0,currcol=0;
        while (length<max){
            for (int i = currcol; i <= right; i++) {
                length++;
                ret[currrow][i] = length;
            }
            currcol=right;
            currrow++;
            up++;
//            if (max==length) return ret;
            // 向下↓
            for (int i = currrow; i <= down; i++) {
                length++;
                ret[i][currcol] = length;
            }
            currrow = down;
            currcol--;
            right--;
            if (max==length) return ret;
            // 向左←
            for (int i = currcol; i >= left; i--) {
                length++;
                ret[currrow][i]=length;
            }
            currrow--;
            currcol = left;
            down--;
//            if (list.size()==length) return list;
            //  向上↑
            for (int i = currrow; i >= up ; i--) {
                length++;
                ret[i][currcol] = length;
            }
            currrow =up;
            currcol++;
            left++;
        }
        return ret;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int length = matrix.length*matrix[0].length;
//        int[] ret = new int[length];
        ArrayList<Integer> list = new ArrayList<>();
//        int add=0;
        int left =0,right = matrix[0].length-1,up=0,down = matrix.length-1;
        int currrow=0,currcol=0;
        while (list.size()<length){
            // 向右→
            for (int i = currcol; i <= right; i++) {
                list.add(matrix[currrow][i]);
            }
            currcol=right;
            currrow++;
            up++;
            if (list.size()==length) return list;
            // 向下↓
            for (int i = currrow; i <= down; i++) {
                list.add(matrix[i][currcol]);
            }
            currrow = down;
            currcol--;
            right--;
            if (list.size()==length) return list;
            // 向左←
            for (int i = currcol; i >= left; i--) {
                list.add(matrix[currrow][i]);
            }
            currrow--;
            currcol = left;
            down--;
            if (list.size()==length) return list;
            //  向上↑
            for (int i = currrow; i >= up ; i--) {
                list.add(matrix[i][currcol]);
            }
            currrow =up;
            currcol++;
            left++;
            if (list.size()==length) return list;
        }
        return list;
    }
}