package com.leon.arithmetic.thousand;

import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    ShortestPathBinaryMatrix1091
  * @Description: 1091. 最短路径
  * @Author:      liyang
  * @Date:        2021/12/20
  * version     1.0.0
 */
public class ShortestPathBinaryMatrix1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid[0].length;
        if (grid[0][0]==1 || grid[n-1][n-1] == 1) return -1;
        int[] dic = {-1,0,1,0,-1};
        int[] angleDic = {-1,-1,1,1,-1};
        //boolean[] visit = new boolean[n * n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        grid[0][0] = 1;
        int count = 1;
        if (n==1) return 1;
        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = poll / n + dic[j];
                    int y = poll % n + dic[j + 1];
                    if (x>=0&&y>=0&&x<n&&y<n&&grid[x][y]==0){
                        if (x==n-1&&y==n-1) return ++count;
                        queue.offer(x*n+y);
                        grid[x][y]=1;
                    }
                }
                for (int j = 0; j < 4; j++) {
                    int x = poll / n + angleDic[j];
                    int y = poll % n + angleDic[j + 1];
                    if (x>=0&&y>=0&&x<n&&y<n&&grid[x][y]==0){
                        if (x==n-1&&y==n-1) return ++count;
                        queue.offer(x*n+y);
                        grid[x][y]=1;
                    }
                }
            }
            count++;
        }
        return -1;

    }

}