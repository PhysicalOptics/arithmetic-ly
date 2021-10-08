package com.leon.arithmetic.onehundred;

import com.leon.util.TreeNode;

import java.util.LinkedList;

/**
  * ClassName:    HasPathSum112
  * @Description: 路径总和一112
  * @Author:      liyang
  * @Date:        2021/9/28
  * version     1.0.0
 */
public class HasPathSum112 {
    // dfs
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left==null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
    
    
    public static void main(String[] args){
        TreeNode treeNode = TreeNode.constructTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        HasPathSum112 sum112 = new HasPathSum112();
        sum112.hasPathSum3(treeNode,22);
    }


    // BFS
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root==null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        LinkedList<Integer> sumQueue = new LinkedList<>();
        sumQueue.offer(0);
        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                Integer sum = sumQueue.poll();
                if (poll.left==null && poll.right==null && (poll.val+sum) == targetSum){
                    return true;
                }
                if (poll.left!=null){
                    queue.offer(poll.left);
                    sumQueue.offer(sum+poll.val);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                    sumQueue.offer(sum+poll.val);
                }
            }
        }
        return false;
    }

//    回溯方法
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        return dfs(0, targetSum, root);
    }

    public boolean dfs(int sum, int target, TreeNode root){
        if (root==null){
            return false;
        }
        if (root.left==null && root.right == null) return target==sum+root.val;
        boolean dfsleft = false;
        if (root.left!=null){
            dfsleft = dfs(sum+root.val, target, root.left);
        }
        boolean dfsright = false;
        if (!dfsleft && root.right != null ){
            dfsright = dfs(sum+root.val, target, root.right);
        }
        // 并且代表遍历到根节点
        return dfsleft || dfsright;
    }
}