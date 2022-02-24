package com.leon.arithmetic.onehundred;

/**
  * ClassName:    MaxPoints149
  * @Description: 149. 直线上最多的点
  * @Author:      liyang
  * @Date:        2021/12/6
  * version     1.0.0
 * 解题心得，两点确定一线，其余的点在线上则加一不在则跳过，临时变量点数以及【最大点数在第三个点遍历完更新】
 */
public class MaxPoints149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            // 第一个点
            int[] x = points[i];
            for (int j = i + 1; j < n; j++) {
                // 第二个点
                int[] y = points[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    //第三个点
                    int[] z = points[k];
                    //int s1 = (y[1] - x[1]) /(y[0] - x[0]);
                    //int s2 = (z[1] - y[1]) /(z[0] - y[0]) ;
                    // 变换
                    int s1 = (y[1] - x[1])*(z[0] - y[0]);
                    int s2 = (z[1] - y[1])*(y[0] - x[0]);

                    if (s1 == s2) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

}