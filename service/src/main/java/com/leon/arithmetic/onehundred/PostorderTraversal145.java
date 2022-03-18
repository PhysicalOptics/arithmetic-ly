package com.leon.arithmetic.onehundred;

import com.leon.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
  * ClassName:    PostorderTraversal145
  * @Description: 145. 二叉树后序遍历
  * @Author:      liyang
  * @Date:        2022/3/10
  * version     1.0.0
 */
public class PostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;


        //List<Integer> list = new ArrayList<>();
        //dfs(root,list);
        //return list;
    }

    public void dfs(TreeNode root,List<Integer> list){
        if (root==null)return;
        dfs(root.left,list);
        dfs(root.right,list);
        list.add(root.val);
    }
}