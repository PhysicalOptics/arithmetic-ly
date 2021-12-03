package com.leon.arithmetic.onehundred;

import java.util.List;

/**
  * ClassName:    MinimumTotal120
  * @Description: 120. 三角形最小路径和
  * @Author:      liyang
  * @Date:        2021/11/15
  * version     1.0.0
 */
public class MinimumTotal120 {

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            // 自底往上推，上一层可覆盖下一层原始的
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle,0,0,memo);


        //int[] dp = new int[triangle.size()];
        //dp[0] = triangle.get(0).get(0);
        //int index = 0;
        //for (int i = 1; i < triangle.size(); i++) {
        //    if (triangle.get(i).get(index)>triangle.get(i).get(index+1)){
        //        dp[i] = dp[i-1]+triangle.get(i).get(index+1);
        //        index = index+1;
        //    }else {
        //        dp[i] = dp[i-1]+triangle.get(i).get(index);
        //    }
        //}
        //return dp[triangle.size()-1];
    }

    public int dfs(List<List<Integer>> triangle,int deep,int index,Integer[][] memo){
        if (deep==triangle.size()){
            return 0;
        }
        if (memo!=null) return memo[deep][index];
        return memo[deep][index] = Math.min(dfs(triangle,deep+1,index,memo),dfs(triangle,deep+1,index,memo))+triangle.get(deep).get(index);

    }
}



class Solution {
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return  dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }
}