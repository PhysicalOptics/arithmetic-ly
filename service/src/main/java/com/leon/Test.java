package com.leon;

import com.leon.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
  * ClassName:    Test
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/8/19
  * version     1.0.0
 */
public class Test {

    ArrayList<Integer> queryTree(TreeNode root){
        ArrayList<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                if (i==size-1) ret.add(peek.val);
                if (peek.left!=null){
                    queue.offer(peek.left);
                }
                if (peek.right!=null){
                    queue.offer(peek.right);
                }
            }
        }
        return ret;
    }
}