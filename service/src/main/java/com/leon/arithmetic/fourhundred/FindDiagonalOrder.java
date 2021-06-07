package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    FindDiagonalOrder
  * @Description: 498
  * @Author:      liyang
  * @Date:        2021/3/26
  * version     1.0.0
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix==null||matrix.length==0) return new int[]{};
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;int flag=1;
        int[] ret = new int[m*n];
        int i=0,j=0;
        while (count<m*n){
            while (i>=0||j<n){
                ret[count] = matrix[i][j];
                count++;
                i--;
                j++;
            }
//            if ()
            i++;
        }
        return ret;
    }
}