package com.leon.arithmetic.ninehundred;

import com.leon.util.TreeNode;

/**
  * ClassName:    RangeSumBST
  * @Description: 938
  * @Author:      liyang
  * @Date:        2021/4/27
  * version     1.0.0
 */
public class RangeSumBST {
    int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);



//        bst(root,low,high);
//        return result;
    }

    private void bst(TreeNode root,int low,int high){
        if (root==null) return;
        bst(root.left,low,high);
        bst(root.right,low,high);
        if (root.val>=low&& root.val<=high){
            result += root.val;
        }
    }

    public static void main(String[] args){
        System.out.println("{invoice_email}".toUpperCase());
    }
}