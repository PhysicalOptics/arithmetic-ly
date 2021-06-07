package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * ClassName:    CombinationSum
  * @Description: 39
  * @Author:      liyang
  * @Date:        2021/4/26
  * version     1.0.0
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int length = candidates.length;
        if (length==0) return lists;
        Arrays.sort(candidates);
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(lists,candidates,target,temp,0);
        return lists;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(lists,candidates,target,temp,0);
        return lists;
    }


    private void dfs(ArrayList<List<Integer>> lists, int[] candidates, int target,ArrayList<Integer> temp,int index){
        if (target==0){
            lists.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target-candidates[i]<0) break;
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            dfs(lists,candidates,target-candidates[i],temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}