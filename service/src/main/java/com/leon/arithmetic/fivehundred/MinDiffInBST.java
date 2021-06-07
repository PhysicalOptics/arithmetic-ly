package com.leon.arithmetic.fivehundred;

import com.leon.arithmetic.util.TreeNode;

/**
  * ClassName:    MinDiffInBST
  * @Description: 530
  * @Author:      liyang
  * @Date:        2021/4/13
  * version     1.0.0
 */
public class MinDiffInBST {
    private int preNodeValue = -1;
    private int result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return this.result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        /*
            中序遍历：
                计算每轮 上一轮遍历到的节点 和 当前节点 的 差绝对值
         */
        inorder(root.left);
        if (this.preNodeValue != -1) {
            // 因为是 二叉搜索树，且为 中序遍历，
            // 因此 左 > 根 > 右，(root.val - this.preNodeValue) 必为正值
            this.result = Integer.min(root.val - this.preNodeValue, this.result);
        }
        this.preNodeValue = root.val;
        inorder(root.right);
    }
}