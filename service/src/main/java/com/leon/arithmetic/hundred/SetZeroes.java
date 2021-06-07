package com.leon.arithmetic.hundred;

/**
  * ClassName:    SetZeroes
  * @Description: 73
  * @Author:      liyang
  * @Date:        2021/3/22
  * version     1.0.0
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean col0_flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            // 行首有0为true
            if (matrix[i][0] == 0) col0_flag = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 设置行首和列首为0
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // ※关键查零是顺序首行首列开始，置零时为保证首行首列不受影响，倒序遍历

        // 从最后一行开始倒序循环
        for (int i = row - 1; i >= 0; i--) {
            // 从最后一列开始倒数循环
            for (int j = col - 1; j >= 1; j--) {
                // 将行首尾首有0的把当前元素置零
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            //一行循环完之后，如果行首列有0 则置当前为0
            if (col0_flag) matrix[i][0] = 0;
        }
    }
}