package com.leon.arithmetic.fivehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
  * ClassName:    FindRotateSteps514
  * @Description: 514. 自由之路
 * 转圆盘找密码，最小操作次数
  * @Author:      liyang
  * @Date:        2022/1/7
  * version     1.0.0
 */
public class FindRotateSteps514 {

    public int findRotateSteps(String ring, String key) {
        int m = key.length();
        int n = ring.length();

        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        // 将ring的字母分别放入对应的字母码表中
        //       4
        //       1  3
        //    a  b  c  d ...
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int[] subdp : dp) {
            Arrays.fill(subdp, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            // ※字母对应的位置，找到ring码表list
            // ※巧妙的将源字符串统计到字母位置，
            for (int j : pos[key.charAt(i) - 'a']) {
                // 如果是key的首字母,只需决定向哪个方向转动
                if (i == 0) {
                    dp[i][j] = Math.min(dp[i][j], clac(n, 0, j) + 1);
                    continue;
                }
                // 如果非首位，则需要考虑前一位的运动量+前一位到当前位置转向最优解
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + clac(n, k, j) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    // ※巧妙的解决向左向右转步数决策
    private int clac(int n, int a, int b) {
        return Math.min((n + a - b) % n, (n + b - a) % n);
    }

}