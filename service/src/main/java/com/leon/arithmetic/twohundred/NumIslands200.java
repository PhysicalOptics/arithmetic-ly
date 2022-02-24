package com.leon.arithmetic.twohundred;

import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    NumIslands200
  * @Description: 200. 岛屿的数量
  * @Author:      liyang
  * @Date:        2021/12/13
  * version     1.0.0
 */
public class NumIslands200 {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //boolean[] visit = new boolean[m * n];
        int count = 0;
        int[] dic = {-1,0,1,0,-1};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1'){
                    count++;
                    queue.offer(i*n+j);
                    grid[i][j] = '0';
                    while (queue.size()>0){
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            Integer poll = queue.poll();
                            for (int a = 0; a < 4; a++) {
                                int x = poll/n+dic[a];
                                int y = poll%n+dic[a+1];
                                if (x>=0&&x<m&&y>=0&&y<n&&grid[x][y]=='1'){
                                    queue.offer(x*n+y);
                                    grid[x][y]='0';
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;



    }
}