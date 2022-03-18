package com.leon.arithmetic.onehundred;

import com.leon.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
  * ClassName:    LevelOrder102
  * @Description: 102. 二叉树层序遍历
  * @Author:      liyang
  * @Date:        2022/3/14
  * version     1.0.0
 */
public class LevelOrder102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root==null) return lists;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null)queue.offer(poll.right);
            }
            lists.add(list);
        }
        return lists;
    }
}