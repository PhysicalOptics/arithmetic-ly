package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * ClassName:    CombinationSum40
  * @Description: 40. 组和总和II 只能用一次
  * @Author:      liyang
  * @Date:        2021/12/21
  * version     1.0.0
 */
public class CombinationSum40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visit = new boolean[candidates.length];
        dfs(lists,temp,candidates,0,target,visit);
        return lists;
    }

    public void dfs(List<List<Integer>> lists, List<Integer> temp,int[] can,int s,int target,boolean[] visit){
        if (target==0){
            lists.add(new ArrayList<>(temp));
        }
        for (int i = s; i < can.length; i++) {
            if (target-can[i]<0) break;
            if (i>s&&can[i]==can[i-1]&&!visit[i-1]) continue;
            temp.add(can[i]);
            visit[i] = true;
            dfs(lists,temp,can,i+1,target-can[i],visit);
            visit[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}