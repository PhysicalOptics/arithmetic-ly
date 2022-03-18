package com.leon.arithmetic.eighthundred;

import com.leon.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    LeafSimilar872
  * @Description: 872. 叶子相同的树
  * @Author:      liyang
  * @Date:        2022/3/10
  * version     1.0.0
 */
public class LeafSimilar872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        dfs(root1,list);
        dfs(root2,list2);
        if (list.size()==list2.size()){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)!= list2.get(i))return false;
            }
            return true;
        }
        return false;


    }

    public void dfs(TreeNode root, List<Integer> list){
        if (root==null) return;
        if (root.left==null&&root.right==null) list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}