package com.leon.arithmetic.eighthundred;

import com.leon.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
  * ClassName:    IncreasingBST897
  * @Description: 897. 递增排列树
  * @Author:      liyang
  * @Date:        2022/3/14
  * version     1.0.0
 */
public class IncreasingBST897 {
    TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        pre = head;
        dfs(root);
        return head.right;
    }

    public void dfs(TreeNode root){
        if (root==null) return;
        dfs(root.left);
        pre.right=root;
        root.left = null;
        pre = root;
        dfs(root.right);
    }
}