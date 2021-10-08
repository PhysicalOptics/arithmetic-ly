package com.leon.arithmetic.hot100;

import com.leon.util.TreeNode;

import java.util.LinkedList;

/**
  * ClassName:    IsSymmetric101
  * @Description: 对称二叉树101
  * @Author:      liyang
  * @Date:        2021/9/27
  * version     1.0.0
 */
public class IsSymmetric101 {

    // 递归
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return false;
        return check(root.left,root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if (left==null&&right==null) return true;
        if (left==null || right==null) return false;
        return left.val==right.val&&check(left.left,right.right)&&check(left.right,right.left);
    }

    // 迭代
    public static boolean isSymmetric2(TreeNode root) {
        if (root==null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        // ※将镜像二叉树转成在队列中连续的
        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size/2; i++) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if (left==null&&right==null) continue;
                if (left== null || right==null) return false;
                if (left.val != right.val) return false;
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        isSymmetric2(treeNode);

    }
}