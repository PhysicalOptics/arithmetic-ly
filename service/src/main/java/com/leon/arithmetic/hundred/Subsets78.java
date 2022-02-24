package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    Subsets78
  * @Description: 78. 子集
  * @Author:      liyang
  * @Date:        2021/12/21
  * version     1.0.0
 */
public class Subsets78 {

    public static void main(String[] args){
        Subsets78 subsets78 = new Subsets78();
        subsets78.subsets(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(lists,list,nums,0);
        return lists;
    }

    public void dfs(List<List<Integer>> lists,List<Integer> templist,int[] nums,int i){
        lists.add(new ArrayList<>(templist));
        for (int j = i; j < nums.length; j++) {
            templist.add(nums[j]);
            dfs(lists,templist,nums,j+1);
            templist.remove(templist.size()-1);
        }
    }
}