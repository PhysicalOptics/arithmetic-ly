package com.leon.arithmetic.fourhundred;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName:    TrapRainWater407
 *
 * @Description: 407. 接雨水二（三维立体）
 * @Author: liyang
 * @Date: 2021/11/3
 * version     1.0.0
 */
public class TrapRainWater407 {

    public static void main(String[] args) {
        for (int i = 0; i < 4; ++i) {
            System.out.println(i);
        }
    }

    public int trapRainWater(int[][] heightMap) {
        // 如果有边长为2，则接不到雨水
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        // 访问过的节点
        boolean[][] visit = new boolean[m][n];
        // 小顶堆，且放入的是数组，比较高度
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    // i * n + j代表第几个
                    // 0    1   2    //4*3d
                    // 3    4   5
                    // 6    7   8
                    // 9    10  11
                    pq.offer(new int[]{i * n + j, heightMap[i][j]});
                    visit[i][j] = true;
                }
            }
        }
        int res = 0;
        // 通过for循环4次则能用i和i+1定位【上，右，下，左】
        int[] dirs = {-1, 0, 1, 0, -1};
        // 如果小顶堆为空
        while (!pq.isEmpty()) {
            // 小顶堆出栈
            int[] curr = pq.poll();
            for (int k = 0; k < 4; ++k) {
                // 第几个取位置，第/n则是行数index，第%n则是第几列数index
                int nx = curr[0] / n + dirs[k];
                int ny = curr[0] % n + dirs[k + 1];
                // 不越界并且没有被访问过
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
                    // 如果当前位置大于周围，则可以注水,并且访问过之后高度为注水后的高度     ※因为这是从最小开始的，比最小还小的则可以接雨水
                    if (curr[1] > heightMap[nx][ny]) {
                        res += curr[1] - heightMap[nx][ny];
                        pq.offer(new int[]{nx * n + ny, curr[1]});
                    } else { // 如果大于则更新边界
                        pq.offer(new int[]{nx * n + ny,heightMap[nx][ny]});
                    }
                    // 将访问过的位置设置为true
                    visit[nx][ny] = true;
                }
            }
        }
        return res;
    }

    public int trapRainWater2(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        int maxHeight = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxHeight = Math.max(maxHeight, heightMap[i][j]);
            }
        }
        int[][] water = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j){
                water[i][j] = maxHeight;
            }
        }
        Queue<int[]> qu = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (water[i][j] > heightMap[i][j]) {
                        water[i][j] = heightMap[i][j];
                        qu.offer(new int[]{i, j});
                    }
                }
            }
        }
        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                // 如果当前的水高度小于周围水，并且周围水大于周围柱子的高度
                //                                 因为最外层水高度就是柱子高度则不满足
                if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]) {
                    // 周围水高度则为，当前水高度和周围柱子的高度的最大值
                    water[nx][ny] = Math.max(water[x][y], heightMap[nx][ny]);
                    qu.offer(new int[]{nx, ny});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res += water[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}
