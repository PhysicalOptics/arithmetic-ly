package com.leon.arithmetic.sevenhundred;

import com.leon.util.TreeNode;

/**
  * ClassName:    SearchBST700
  * @Description: 700. 二叉搜索树的搜索
  * @Author:      liyang
  * @Date:        2022/3/14
  * version     1.0.0
 */
public class SearchBST700 {
    TreeNode treeNode = null;
    public TreeNode searchBST(TreeNode root, int val) {
        dfs(root,val);
        return treeNode;
    }

    public void dfs(TreeNode root,int val){
        if (root==null) return;
        if (root.val==val) {
            treeNode = root;
            return;
        }
        dfs(root.left,val);
        dfs(root.right,val);
    }

}