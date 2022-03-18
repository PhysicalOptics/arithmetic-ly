package com.leon.arithmetic.onehundred;

import com.leon.util.TreeNode;

/**
  * ClassName:    IsSameTree100
  * @Description: 是否是相同的树
  * @Author:      liyang
  * @Date:        2022/3/10
  * version     1.0.0
 */
public class IsSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        if (p==null||q==null)return false;
        if (p.val!=q.val) return false;
        boolean dfsleft = isSameTree(p.left, q.left);
        boolean dfsright = isSameTree(p.right, q.right);
        return dfsleft&&dfsright;
    }
    //
    //public boolean dfs(TreeNode p, TreeNode q){
    //    if (p==null&&q==null) return true;
    //    if (p==null||q==null)return false;
    //    if (p.val!=q.val) return false;
    //    boolean dfsleft = dfs(p.left, q.left);
    //    boolean dfsright = dfs(p.right, q.right);
    //    return dfsleft&&dfsright;
    //}
}