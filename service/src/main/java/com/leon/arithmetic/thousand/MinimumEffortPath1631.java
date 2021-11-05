package com.leon.arithmetic.thousand;

import com.leon.util.TransSZ;
import com.leon.util.UnionFind;

import java.util.*;

/**
 * ClassName:    MinimumEffortPath1631
 *
 * @Description: 1631、远足最小耗费体力值
 * @Author: liyang
 * @Date: 2021/11/3
 * version     1.0.0
 */
public class MinimumEffortPath1631 {

    public static void main(String[] args){
        int[][] h = {{1,2,2},{3,8,2},{5,3,5}};
        minimumEffortPath(h);
    }

    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int id = i * n + j;
                if (j > 0) {
                    // 加上a--b，左右权值的边
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
                if (i > 0) {
                    // 加上上下权值的边
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
            }
        }
        // 排序权值从小到大
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });

        // 创建并集
        UnionFind uf = new UnionFind(m * n);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.unite(x, y);
            if (uf.connected(0, m * n - 1)) {
                ans = v;
                break;
            }
        }
        return ans;
    }

    // 二分法，效率低
    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 1000000;
        int[] dic = new int[]{-1, 0, 1, 0, -1};
        while (left < right) {
            int mid = left + (right - left) / 2;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            boolean[] visit = new boolean[m * n];
            visit[0] = true;
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                int x = poll / n;
                int y = poll % n;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dic[i];
                    int ny = y + dic[i + 1];
                    int p = nx * n + ny;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[p] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        queue.offer(p);
                        visit[p] = true;
                    }
                }
            }
            if (visit[m * n - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}