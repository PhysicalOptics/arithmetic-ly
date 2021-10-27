package com.leon.arithmetic.hundred;

/**
  * ClassName:    Rotate48
  * @Description: 48. 旋转图像
  * @Author:      liyang
  * @Date:        2021/10/14
  * version     1.0.0
 */
public class Rotate48 {
    public static void main(String[] args){
        Rotate48 rotate48 = new Rotate48();
        rotate48.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            // 起点  i,i
            for (int j = 0; j < n-2*i-1; j++) {
                int temp = matrix[i][i+j];

                // i,i起点基准  n-2*i 旋转方块的边长
                // 左下--》左上  左顺位上    【i】[增大] = [减小]【i】
                matrix[i][i+j] = matrix[i+n-2*i-1-j][i];
                // 右下--》左下  下顺位左    [减小]【i】 = 【i+边长-1】[减小]
                matrix[i+n-2*i-1-j][i] = matrix[i+n-2*i-1][i+n-2*i-1-j];
                // 右上--》右下  右顺位下    【i+边长-1】[减小] = [增大]【i+边长-1】
                matrix[i+n-2*i-1][i+n-2*i-1-j] = matrix[i+j][i+n-2*i-1];
                // 左上--》右上  上顺位右    [增大]【i+边长-1】 = 【i】[增大]
                matrix[i+j][i+n-2*i-1] = temp;
            }
        }
    }
}