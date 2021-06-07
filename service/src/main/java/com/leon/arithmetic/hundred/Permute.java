package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    Permute
  * @Description: 46
  * @Author:      liyang
  * @Date:        2021/4/26
  * version     1.0.0
 */
public class Permute {
    public List<List<Integer>> permute(int[] candidates) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int length = candidates.length;
        if (length==0) return lists;
        boolean[] used = new boolean[length];
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(lists,candidates,used,temp);
        return lists;
    }

    private void dfs(ArrayList<List<Integer>> lists, int[] candidates, boolean[] used,ArrayList<Integer> temp){
        if (temp.size()==candidates.length){
            lists.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.add(candidates[i]);
            dfs(lists,candidates,used,temp);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}