package com.leon.arithmetic.onehundred;

import com.leon.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
  * ClassName:    PathSum113
  * @Description: 路径总和【二】 113
  * @Author:      liyang
  * @Date:        2021/9/29
  * version     1.0.0
 */
public class PathSum113 {

    public static void main(String[] args){
        TreeNode treeNode = TreeNode.constructTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        PathSum113 pathSum113 = new PathSum113();
        pathSum113.pathSum(treeNode,22);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(targetSum,root,list,temp);
        return list;
    }

    public void dfs(int sum, TreeNode root, List<List<Integer>> list, List<Integer> temp){
        if (root == null) return;
        temp.add(root.val);
        if (root.left==null && root.right==null){
            if (sum-root.val==0){
                ArrayList<Integer> ret = new ArrayList<>(temp);
                list.add(ret);
            }
            temp.remove(temp.size()-1);
            return;
        }
        if (sum-root.val>=0){
            dfs(sum-root.val,root.left,list,temp);
            dfs(sum-root.val,root.right,list,temp);
        }
        temp.remove(temp.size()-1);
    }
}