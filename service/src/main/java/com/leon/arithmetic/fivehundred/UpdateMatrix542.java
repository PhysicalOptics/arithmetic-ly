package com.leon.arithmetic.fivehundred;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName:    UpdateMatrix542
 *
 * @Description: 542. 矩阵离0的距离
 * @Author: liyang
 * @Date: 2021/11/11
 * version     1.0.0
 */
public class UpdateMatrix542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ret = new int[m][n];
        int[] dic = {-1, 0, 1, 0, -1};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = -1;
                if (mat[i][j] == 0){
                    queue.offer(i * n + j);
                    ret[i][j] = 0;
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                int x = poll / n;
                int y = poll % n;
                for (int j = 0; j < 4; j++) {
                    int nx = x + dic[j];
                    int ny = y + dic[j + 1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && ret[nx][ny] == -1) {
                        ret[nx][ny] = distance;
                        queue.offer(nx * n + ny);
                    }
                }
            }
        }
        return ret;
    }
}