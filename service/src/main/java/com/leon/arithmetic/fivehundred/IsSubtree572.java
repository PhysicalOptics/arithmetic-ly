package com.leon.arithmetic.fivehundred;

import com.leon.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    IsSubtree572
  * @Description: 572. 包含子树
  * @Author:      liyang
  * @Date:        2021/12/14
  * version     1.0.0
 */
public class IsSubtree572 {


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size()!=0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.val == subRoot.val&&dfsCheck(root,subRoot)){
                    return true;
                }
                if (root.left!=null){
                    queue.offer(root.left);
                }
                if (root.right!= null){
                    queue.offer(root.right);
                }
            }
        }
        return false;
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }

    //递归当前树
    public boolean dfs(TreeNode root, TreeNode subRoot){
        // ※※※※※---先判空先判空---※※※※※
        if (root==null) return false;
        return dfsCheck(root,subRoot)||dfs(root.left,subRoot)||dfs(root.right,subRoot);
    }

    // 递归检查数相同
    public boolean dfsCheck(TreeNode root,TreeNode subRoot){
        if (root==null&&subRoot==null) return true;
        if (root==null||subRoot==null||root.val!=subRoot.val) return false;
        boolean dfs = dfsCheck(root.left, subRoot.left);
        boolean dfs1 = dfsCheck(root.right, subRoot.right);
        return dfs&&dfs1;
    }
}