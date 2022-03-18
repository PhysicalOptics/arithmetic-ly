package com.leon.arithmetic.sixhundred;

import com.leon.util.TreeNode;

/**
  * ClassName:    FindSecondMinimumValue671
  * @Description: 671. 二叉树第二小的节点（二叉树父节点是取左右最小的那个）
  * @Author:      liyang
  * @Date:        2022/3/14
  * version     1.0.0
 */
public class FindSecondMinimumValue671 {

    public static void main(String[] args){
        FindSecondMinimumValue671 value671 = new FindSecondMinimumValue671();
        int secondMinimumValue = value671.findSecondMinimumValue(TreeNode.constructTree(new Integer[]{2, 2, 5, null, null, 5, 7}));
        System.out.println(secondMinimumValue);
    }
    int ret =-1;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root,root.val);
        return ret;
    }

    public void dfs(TreeNode root,int min){
        if (root==null) return;
        if (root.val!=min){
            if (ret==-1) ret = root.val;
            else ret = Math.min(ret,root.val);
            return;
        }
        dfs(root.left,min);
        dfs(root.right,min);

    }
}