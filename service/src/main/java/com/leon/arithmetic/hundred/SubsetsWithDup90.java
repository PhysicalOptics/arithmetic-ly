package com.leon.arithmetic.hundred;

import java.util.*;

/**
  * ClassName:    SubsetsWithDup90
  * @Description: 90. 子集II 有重复数
  * @Author:      liyang
  * @Date:        2021/12/21
  * version     1.0.0
 */
public class SubsetsWithDup90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(lists,list,nums,0);
        return lists;
    }

    public void backTrace(List<List<Integer>> lists,List<Integer> templist,int[] nums,int s){
        lists.add(new ArrayList<>(templist));
        for (int i = s; i < nums.length; i++) {
            if (i != s && nums[i] == nums[i - 1])
                continue;
            templist.add(nums[i]);
            backTrace(lists,templist,nums,i+1);
            templist.remove(templist.size()-1);
        }
    }
}