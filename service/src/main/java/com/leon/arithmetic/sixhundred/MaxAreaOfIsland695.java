package com.leon.arithmetic.sixhundred;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName:    MaxAreaOfIsland695
 *
 * @Description: 695. 岛屿的最大面积
 * @Author: liyang
 * @Date: 2021/10/20
 * version     1.0.0
 */
public class MaxAreaOfIsland695 {

    public static void main(String[] args){
        MaxAreaOfIsland695 island695 = new MaxAreaOfIsland695();
        island695.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}});
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ret = 0;
        //boolean[][] used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==0 ) continue;
                int count = areaCount(grid, i, j);
                ret = Math.max(ret, count);
            }
        }
        return ret;
    }

    public int areaCount(int[][] grid, int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = 0;
        int count = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int i1 = poll[0];
                int j1 = poll[1];
                if (i1 - 1 >= 0 && grid[i1 - 1][j1] == 1) {
                    queue.offer(new int[]{i1 - 1, j1});
                    grid[i1 - 1][j1] = 0;
                    count++;
                }
                if (i1 + 1 < grid.length && grid[i1 + 1][j1] == 1) {
                    queue.offer(new int[]{i1 + 1, j1});
                    grid[i1 + 1][j1] = 0;
                    count++;
                }
                if (j1 - 1 >= 0 && grid[i1][j1 - 1] == 1) {
                    queue.offer(new int[]{i1, j1 - 1});
                    grid[i1][j1 - 1] = 0;
                    count++;
                }
                if (j1 + 1 < grid[0].length && grid[i1][j1 + 1] == 1) {
                    queue.offer(new int[]{i1, j1 + 1});
                    grid[i1][j1 + 1] = 0;
                    count++;
                }

            }
        }
        return count;
    }

}