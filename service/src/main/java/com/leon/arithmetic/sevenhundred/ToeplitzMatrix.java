package com.leon.arithmetic.sevenhundred;

/**
  * ClassName:    ToeplitzMatrix
  * @Description: 766
  * @Author:      liyang
  * @Date:        2021/2/22
  * version     1.0.0
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵
 */
public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int count = 0;
        /*int h = matrix.length - 2;
        int w = matrix[0].length-2;
        while (h >= 0){
            for (int i = h+1; i < matrix.length && i-h<matrix[0].length ; i++) {
                count++;
                if (matrix[h][0] != matrix[i][i-h]){
                    return false;
                }
            }
            h--;
        }
        while (w>0){
            for (int i = w+1; i < matrix[0].length && i-w < matrix.length  ; i++) {
                count++;
                if (matrix[0][w] != matrix[i-w][i]){
                    return false;
                }
            }
            w--;

        }
        return true;*/
        for (int i = 0; i < matrix.length - 1; ++i) {
            for (int j = 0; j < matrix[0].length - 1; ++j) {
                count++;
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] ints = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(ints));
    }
}