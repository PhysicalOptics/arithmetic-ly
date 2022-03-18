package com.leon.arithmetic.onehundred;

import com.leon.util.TreeNode;

import java.util.*;

/**
  * ClassName:    ZigzagLevelOrder103
  * @Description: 103. 二叉树锯齿遍历
  * @Author:      liyang
  * @Date:        2022/3/10
  * version     1.0.0
 */
public class ZigzagLevelOrder103 {
    public static void main(String[] args){
        TreeNode treeNode = TreeNode.constructTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ZigzagLevelOrder103 zigzagLevelOrder103 = new ZigzagLevelOrder103();
        zigzagLevelOrder103.zigzagLevelOrder2(treeNode);
    }

    // 通过add方式改变前后顺序
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    // 通过offer queue方式添加顺序
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root==null) return lists;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean f=true;
        while (queue.size()>0){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (f){
                    TreeNode treeNode = queue.pollLast();
                    list.add(treeNode.val);
                    if (treeNode.left!=null) queue.offerFirst(treeNode.left);
                    if (treeNode.right!=null) queue.offerFirst(treeNode.right);
                }else {
                    TreeNode treeNode = queue.pollFirst();
                    list.add(treeNode.val);
                    if (treeNode.right!=null)queue.offerLast(treeNode.right);
                    if (treeNode.left!=null) queue.offerLast(treeNode.left);
                }
            }
            f=!f;
            lists.add(list);
        }
        return lists;
    }
}