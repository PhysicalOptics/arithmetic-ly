package com.leon.arithmetic.ninehundred;

import com.leon.util.TransSZ;

import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    OrangesRotting994
  * @Description: 994. 腐烂的橘子
  * @Author:      liyang
  * @Date:        2021/11/8
  * version     1.0.0
 */
public class OrangesRotting994 {

    public static void main(String[] args){
        int i = orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
    }

    public static int orangesRotting(int[][] grid) {
        int[] dic = {-1,0,1,0,-1};
        // 好的橘子个数
        int bestsum = 0,minute = 0;
        int clo = grid.length;
        int row = grid[0].length;
        // 初始腐烂的橘子
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[clo * row];
        for (int i = 0; i < clo*row; i++) {
            int x = i / row;
            int y = i % row;
            if (grid[x][y]==1){
                // 所有的好的
                bestsum++;
            }else if (grid[x][y]==2){
                // 所有的坏的
                queue.offer(i);
                visit[i] = true;
            }else if (grid[x][y]==0){
                // 空的首次则置访问过
                visit[i] = true;
            }
        }
        while (!queue.isEmpty()){
            if (bestsum==0) return minute;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer p = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p / row + dic[j];
                    int ny = p % row + dic[j + 1];
                    // 如果周围是好的橘子则感染加入队列，并且访问置为true
                    if (nx>=0&&nx<clo&&ny>=0&&ny<row&&!visit[nx*row+ny]&&grid[nx][ny]==1){
                        queue.offer(nx*row+ny);
                        visit[nx*row+ny] = true;
                        bestsum--;
                    }
                }
            }
            minute++;


        }
        if (bestsum>0) return -1;
        else return minute;

    }
}