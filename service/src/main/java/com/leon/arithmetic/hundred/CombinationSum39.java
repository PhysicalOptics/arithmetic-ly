package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * ClassName:    CombinationSum39
  * @Description: 39. 组和总数
  * @Author:      liyang
  * @Date:        2021/12/21
  * version     1.0.0
 */
public class CombinationSum39 {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(lists,temp,candidates,0,target);
        return lists;
    }

    public void dfs(List<List<Integer>> lists, List<Integer> templist, int[] candidates,int start, int target){
        if (target==0){
            lists.add(new ArrayList<>(templist));
        }else if (target<0){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target-candidates[i]<0) break;
            templist.add(candidates[i]);
            dfs(lists,templist,candidates,i,target-candidates[i]);
            templist.remove(templist.size()-1);
        }
    }
}