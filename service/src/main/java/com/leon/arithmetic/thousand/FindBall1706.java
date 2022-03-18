package com.leon.arithmetic.thousand;

/**
  * ClassName:    FindBall1706
  * @Description: 1706. 球会落向何处
  * @Author:      liyang
  * @Date:        2022/2/25
  * version     1.0.0
 */
public class FindBall1706 {


    public int[] findBall(int[][] grid) {
        int[] ret = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            check(grid,0,i,ret,i);
        }
        return ret;
    }

    public void check(int[][] grid,int c,int r,int[] ret,int i){
        if (c==grid.length){
            ret[i] = r;
            return;
        }
        int n = r + grid[c][r];
        if (n<0||n==grid[0].length||grid[c][n]+grid[c][r]==0){
            ret[i] = -1;
            return;
        }
        check(grid,c+1,n,ret,i);
    }
}