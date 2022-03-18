package com.leon.arithmetic.onehundred;

import com.leon.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
  * ClassName:    PreorderTraversal144
  * @Description: 144. 二叉树前序遍历
  * @Author:      liyang
  * @Date:        2022/3/11
  * version     1.0.0
 */
public class PreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (stack.size()>0||root!=null){
            while (root!=null){
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            TreeNode pop = stack.pop();
            root = pop.right;
        }
        return list;
        //ArrayList<Integer> list = new ArrayList<>();
        //dfs(root,list);
        //return list;
    }

    public void dfs(TreeNode root,List<Integer> list){
        if (root==null) return;
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}