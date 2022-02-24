package com.leon.arithmetic.threehundred;

import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    ColorBorder1034
  * @Description: 1034. 边界着色
  * @Author:      liyang
  * @Date:        2021/12/7
  * version     1.0.0
 */
public class ColorBorder1034 {

    public static void main(String[] args){
        //colorBorder(new int[][]{{1,1},{1,2}},0,0,3);
        boolean[] booleans = new boolean[3];
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
    }
    
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        // 如果开始点的颜色与改后颜色一致则无需遍历找连通分量
        int firstColor = grid[row][col];
        if (firstColor==color) return grid;

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        int s = row * n + col;
        queue.offer(s);
        grid[row][col] = color;
        visit[row][col] = true;

        int[] dir = new int[]{-1,0,1,0,-1};

        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                int t = 0;
                for (int j = 0; j < 4; j++) {
                    int x1 = poll / n + dir[j];
                    int y1 = poll % n + dir[j+1];
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && firstColor == grid[x1][y1]&& !visit[x1][y1]){
                        grid[x1][y1] = color;
                        visit[x1][y1] = true;
                        queue.offer(x1*n+y1);
                    }
                    // 四方有改过值则为连通
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && visit[x1][y1]) t++;
                }
                // 如果四方为连通，则自己就还原初始值
                if (t==4) grid[poll/n][poll%n] = firstColor;
            }
        }
        return grid;
    }

    // 错误的做法，只考虑到首节点的四方连通
    public int[][] colorBorderError(int[][] grid, int row, int col, int color) {
        // 如果开始点的颜色与改后颜色一致则无需遍历找连通分量
        int firstColor = grid[row][col];
        if (firstColor==color) return grid;

        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int s = row * n + col;
        queue.offer(s);
        grid[row][col] = color;

        int[] dir = new int[]{-1,0,1,0,-1};

        // 判断自己是不是连通分量
        boolean self = false;
        if (row==0||row==m-1||col==0||col==n-1) self = true;
        else {
            for (int i = 0; i < 4; i++) {
                int x1 = row + dir[i];
                int y1 = col + dir[i+1];
                if (firstColor!=grid[x1][y1]){
                    self = true;
                    break;
                }
            }
        }

        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x1 = poll / n + dir[j];
                    int y1 = poll % n + dir[j+1];
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && firstColor == grid[x1][y1]){
                        grid[x1][y1] = color;
                        queue.offer(x1*n+y1);
                    }
                }
            }
        }
        if (!self) grid[row][col] = firstColor;
        return grid;
    }

}