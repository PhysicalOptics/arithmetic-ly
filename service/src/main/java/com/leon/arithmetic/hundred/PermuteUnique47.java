package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * ClassName:    PermuteUnique47
  * @Description: 47. 全排列II 包含重复的数字
  * @Author:      liyang
  * @Date:        2021/12/21
  * version     1.0.0
 */
public class PermuteUnique47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> templist = new ArrayList<>();
        backtrace(lists,templist,nums,visit);
        return lists;
    }

    public void backtrace(List<List<Integer>> lists,List<Integer> templist,int[] nums,boolean[] visit){
        if (templist.size()==nums.length){
            lists.add(new ArrayList<>(templist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            // 将两个相同的数排在前面的必须先填出去
            if (i>0&&nums[i]==nums[i-1]&&!visit[i-1]) continue;
            templist.add(nums[i]);
            visit[i] = true;
            backtrace(lists,templist,nums,visit);
            templist.remove(templist.size()-1);
            visit[i] = false;
        }
    }

}