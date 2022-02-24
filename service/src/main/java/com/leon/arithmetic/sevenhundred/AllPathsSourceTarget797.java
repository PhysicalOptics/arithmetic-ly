package com.leon.arithmetic.sevenhundred;

import cn.hutool.core.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
  * ClassName:    AllPathsSourceTarget797
  * @Description: 797. 所有可能路径
  * @Author:      liyang
  * @Date:        2021/12/20
  * version     1.0.0
 */
public class AllPathsSourceTarget797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(lists,list,graph,0);
        return lists;
    }

    public void dfs(List<List<Integer>> lists,List<Integer> templist,int[][] graph,int s){
        templist.add(s);
        if (s==graph.length-1){
            lists.add(new ArrayList<>(templist));
            templist.remove(templist.size()-1);
            return;
        }
        for (int a : graph[s]) {
            dfs(lists,templist,graph,a);
        }
        templist.remove(templist.size()-1);
    }

}