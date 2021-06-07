package com.leon.arithmetic.eighthundred;

/**
  * ClassName:    Transpose
  * @Description: 867
  * @Author:      liyang
  * @Date:        2021/2/25
  * version     1.0.0
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int[][] ret = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ret[j][i] = matrix[i][j];
            }
        }
        return ret;
    }
}