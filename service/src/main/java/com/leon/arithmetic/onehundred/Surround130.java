package com.leon.arithmetic.onehundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    Surround130
  * @Description: 130. 被围绕的区域
  * @Author:      liyang
  * @Date:        2021/12/20
  * version     1.0.0
 */
public class Surround130 {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0]=='O'){
                queue.offer(i*n);
                list.add(i*n);
                board[i][0] = 'X';
            }
            if (board[i][n-1]=='O'){
                queue.offer(i*n+n-1);
                list.add(i*n+n-1);
                board[i][n-1]='X';
            }
        }
        for (int i = 1; i < n-1; i++) {
            if (board[0][i]=='O'){
                queue.offer(i);
                list.add(i);
                board[0][i]='X';
            }
            if (board[m-1][i]=='O'){
                queue.offer((m-1)*n+i);
                list.add((m-1)*n+i);
                board[m-1][i]='X';
            }
        }

        int[] dic = {-1,0,1,0,-1};
        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = poll / n + dic[j];
                    int y = poll % n + dic[j + 1];
                    if (x>=0&&y>=0&&x<m&&y<n&&board[x][y]=='O'){
                        queue.offer(x*n+y);
                        list.add(x*n+y);
                        board[x][y]='X';
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (list.contains(i*n+j)){
                    board[i][j]='O';
                }else {
                    board[i][j]='X';
                }
            }
        }

    }
}