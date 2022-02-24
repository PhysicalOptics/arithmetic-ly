package com.leon.arithmetic.hundred;

import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    ExistWord79
  * @Description: 单词搜索
  * @Author:      liyang
  * @Date:        2021/10/15
  * version     1.0.0
 */
public class ExistWord79 {

    public static void main(String[] args){
        String s = "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]";
        String replace = s.replace("[", "{");
        String replace1 = replace.replace("]", "}");
        System.out.println(replace1);


        ExistWord79 word79 = new ExistWord79();
        boolean see = word79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
        System.out.println(see);
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] used = new boolean[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]==chars[0]){
                    if (backtrace(board,i*n+j,word,1,used)) return true;
                }
            }
        }
        return false;


    }
    int[] dic = {-1,0,1,0,-1};

    public boolean backtrace(char[][] board,int s,String word, int index, boolean[] used){
        if (index==word.length()){
            return true;
        }
        used[s] = true;
        int n = board[0].length;
        for (int i = 0; i < 4; i++) {
            int x = s / n + dic[i];
            int y = s % n + dic[i+1];
            if (x>=0&&y>=0&&x<board.length&&y<n&&!used[x*n+y]&&board[x][y]==word.charAt(index)){
                if (backtrace(board,x*n+y,word,index+1,used)) return true;
            }
        }
        used[s] = false;
        return false;
    }















    //public boolean exist(char[][] board, String word) {
    //    char[] chars = word.toCharArray();
    //    boolean[][] used = new boolean[board.length][board[0].length];
    //    for (int i = 0; i < board.length; i++) {
    //        for (int j = 0; j < board[0].length; j++) {
    //            if (board[i][j] == chars[0]){
    //                if (check(chars, board, i, j, used, 1)) return true;
    //            }
    //        }
    //    }
    //    return false;
    //
    //}
    //// 上下左右
    //private int[][] pos = {{-1,0}, {1,0},{0,-1},{0,1}};
    //
    //public boolean check(char[] chars,char[][] board,int i, int j,boolean[][] used,int index){
    //    if (index==chars.length) return true;
    //    used[i][j] = true;
    //
    //    for (int k = 0; k < pos.length; k++) {
    //        int i1 = i + pos[k][0];
    //        int j1 = j + pos[k][1];
    //        if (i1>=0 && i1<board.length && j1>=0 && j1<board[0].length){
    //            if (chars[index]==board[i1][j1] && !used[i1][j1]){
    //                if (check(chars,board,i1,j1,used,index+1)) return true;
    //            }
    //        }
    //    }
    //    used[i][j] = false;
    //    return false;
    //}

}