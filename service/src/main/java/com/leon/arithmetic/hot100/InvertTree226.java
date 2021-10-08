package com.leon.arithmetic.hot100;

import com.leon.util.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
  * ClassName:    InvertTree226
  * @Description: 翻转二叉树226
  * @Author:      liyang
  * @Date:        2021/9/27
  * version     1.0.0
 */
public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        if (root==null) return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        dfs(root.left);
        dfs(root.right);
    }
}