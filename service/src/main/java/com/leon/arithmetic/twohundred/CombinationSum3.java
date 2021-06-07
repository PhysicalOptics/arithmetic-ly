package com.leon.arithmetic.twohundred;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    CombinationSum3
  * @Description: 216
  * @Author:      liyang
  * @Date:        2021/4/26
  * version     1.0.0
 */
public class CombinationSum3 {

    // 和为n的k个数
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(lists,9,n,1,temp,k);
        return lists;
    }

    private void dfs(ArrayList<List<Integer>> lists,int candidate,int target,int index,ArrayList<Integer> temp,int k){
        if (target == 0&& temp.size()==k){
            lists.add(new ArrayList<>(temp));
        }
        for (int i = index; i <= 9 ; i++) {
            if (target-i<0) break;
            temp.add(i);
            dfs(lists,9,target-i,i+1,temp,k);
            temp.remove(temp.size()-1);
        }
    }
}