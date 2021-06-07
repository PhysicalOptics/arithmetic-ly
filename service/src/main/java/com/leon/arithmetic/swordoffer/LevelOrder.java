package com.leon.arithmetic.swordoffer;

import com.leon.arithmetic.util.TreeNode;

import java.util.*;

/**
  * ClassName:    LevelOrder
  * @Description: 32
  * @Author:      liyang
  * @Date:        2021/3/26
  * version     1.0.0
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode pop = queue.poll();
            result.add(pop.val);
            if (pop.left!=null)queue.add(pop.left);
            if (pop.right!=null)queue.add(pop.right);
        }

        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[0] = result.get(i);
        }
        return ints;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

}