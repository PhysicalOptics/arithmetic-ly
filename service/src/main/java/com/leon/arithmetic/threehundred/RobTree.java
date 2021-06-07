package com.leon.arithmetic.threehundred;

import com.leon.arithmetic.tree.NodeTree;

/**
  * ClassName:    RobTree
  * @Description: 337
  * @Author:      liyang
  * @Date:        2021/3/16
  * version     1.0.0
 */
public class RobTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}