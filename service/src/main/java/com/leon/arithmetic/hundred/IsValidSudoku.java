package com.leon.arithmetic.hundred;

import java.util.HashSet;
import java.util.Random;

/**
  * ClassName:    IsValidSudoku
  * @Description: 36有效的数独
  * @Author:      liyang
  * @Date:        2021/9/17
  * version     1.0.0
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] quares = new int[9][9];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j]=='.') continue;
                int a = board[i][j]-'0'-1;
                rows[i][a]++;
                cols[j][a]++;
                quares[i/3*3+(j/3)][a]++;
                if (rows[i][a]>1||cols[j][a]>1||quares[i/3*3+(j/3)][a]>1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int r = random.nextInt(5);
            System.out.println(r);
        }

    }
}