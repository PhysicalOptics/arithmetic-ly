package com.leon.arithmetic.hundred;

import com.leon.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    IsValidBST98
  * @Description: 98、是否是二叉搜索数
  * @Author:      liyang
  * @Date:        2021/10/9
  * version     1.0.0
 */
public class IsValidBST98 {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        return dfs(root,list);
    }

    // pre=Long.minval;max=Long.maxval
    public boolean dfs3(TreeNode root,int pre,int max){
        if (root==null) return true;
        if (root.val<=pre || root.val>=max) return false;
        return dfs3(root.left,pre,root.val) && dfs3(root.right,root.val,max);
    }

    // pre = Long.minval;
    public boolean dfs2(TreeNode root,int pre){
        if (root == null) return true;
        boolean l = dfs2(root.left, pre);
        if (root.val<pre) return false;
        pre = root.val;
        boolean r = dfs2(root.right, pre);
        return l&&r;
    }

    // 中序遍历
    public boolean dfs(TreeNode root,List<Integer> list){
        if (root==null) return true;
        boolean dfs1 = dfs(root.left, list);

        Integer val = root.val;
        if (list.size()>0 && val<list.get(list.size()-1)) return false;
        list.add(val);

        boolean dfs2 = dfs(root.right,list);
        return dfs1 && dfs2;
    }
}