package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    Combine77
  * @Description: 77. 组和
  * @Author:      liyang
  * @Date:        2021/11/12
  * version     1.0.0
 */
public class Combine77 {

    public static void main(String[] args){
        Combine77 combine77 = new Combine77();
        combine77.combine(4,2);
        System.out.println(123);
    }

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        dfs(lists,new ArrayList<Integer>(),k,1,n);
        return lists;
    }

    public void dfs(ArrayList<List<Integer>> lists, ArrayList<Integer> temp, int k, int s, int n){
        if (temp.size()==k){
            lists.add(new ArrayList<>(temp));
            return;
        }
        for (int i = s; i <= n-k+temp.size()+1; i++) {
            temp.add(i);
            dfs(lists,temp,k,i+1,n);
            temp.remove(temp.size()-1);
        }
    }
}