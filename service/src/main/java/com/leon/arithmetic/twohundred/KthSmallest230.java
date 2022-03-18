package com.leon.arithmetic.twohundred;

import com.leon.util.TreeNode;

import java.util.*;

/**
  * ClassName:    KthSmallest230
  * @Description: 230. 二叉搜索树第K小
  * @Author:      liyang
  * @Date:        2022/3/10
  * version     1.0.0
 */
public class KthSmallest230 {
    public static void main(String[] args){
        TreeNode root = TreeNode.constructTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, null, 10, null, 11, 12, 13});
        root.afterOrder(root);
        System.out.println("-----------------------");
        root.afterOrder2(root);

    }

    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.offerLast(root);
                root = root.left;
            }
            root = queue.pollLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root,k,list);
        return list.get(k-1);
    }

    public void dfs(TreeNode root,int k,List<Integer> list){
        if (root==null) return;
        if (list.size()==k)return;
        dfs(root.left,k,list);
        list.add(root.val);
        dfs(root.right,k,list);
    }
}
