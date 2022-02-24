package com.leon.arithmetic.thousand;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    LuckyNumbers1380
  * @Description: 
  * @Author:      liyang
  * @Date:        2022/2/15
  * version     1.0.0
 */
public class LuckyNumbers1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int index = 0;
            // 找到每行最小数的index
            for (int j = 0; j < matrix[i].length; j++) {
                index = matrix[i][j] > matrix[i][index] ? index : j;
            }
            // 判断最小数是不是列中最大数
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][index]>matrix[i][index]) break;
                if (j==matrix.length-1) list.add(matrix[i][index]);
            }
        }
        return list;
    }
}