package com.leon.arithmetic.onehundred;

import com.leon.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
  * ClassName:    RightSideView199
  * @Description: 199. 二叉树右视图
  * @Author:      liyang
  * @Date:        2022/3/14
  * version     1.0.0
 */
public class RightSideView199 {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null) return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i==size-1){
                    list.add(poll.val);
                }
                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null)queue.offer(poll.right);
            }
        }
        return list;
    }
}