package com.leon.arithmetic.thousand;

import com.leon.util.TreeNode;

/**
  * ClassName:    BstToGst1038
  * @Description: 1038. 二叉搜索树的和树
  * @Author:      liyang
  * @Date:        2022/3/14
  * version     1.0.0
 */
public class BstToGst1038 {
    public static void main(String[] args){
        BstToGst1038 gst1038 = new BstToGst1038();
        gst1038.bstToGst(TreeNode.constructTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8}));
    }

    int sum = 0;
    int pre = 0;


    // 最佳解法538，反转中序赋值
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        this.convertBST(root.right);
        sum += root.val;
        root.val = sum;
        this.convertBST(root.left);
        return root;
    }









    public TreeNode bstToGst(TreeNode root) {
        sumDfs(root);
        inDfs(root);
        return root;
    }


    public void inDfs(TreeNode root){
        if (root==null) return;
        inDfs(root.left);
        sum-=pre;
        pre = root.val;
        root.val = sum;
        inDfs(root.right);
    }

    public void sumDfs(TreeNode root){
        if (root==null) return;
        sum+=root.val;
        sumDfs(root.left);
        sumDfs(root.right);
    }
}