package com.leon.arithmetic.hot100;

import com.leon.util.Node;
import com.leon.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
  * ClassName:    MaxDepth104
  * @Description: 二叉树最大深度104
  * @Author:      liyang
  * @Date:        2021/9/27
  * version     1.0.0
 */
public class MaxDepth104 {
    // 深度优先
    public int maxDepth(TreeNode root) {
        if (root== null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }

    // 广度优先
    public int maxDepth2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root!=null){
            queue.offer(root);
        }
        int depth=0;
        while (queue.size()>0){
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }

    // 扩展多叉树深度
    public int maxDepth2(Node root) {
        if (root==null) return 0;
        int max=0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max+1;
    }
    public int maxDepth(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root!=null){
            queue.offer(root);
        }
        int depth=0;
        while (queue.size()>0){
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                for (Node child : poll.children) {
                    queue.offer(child);
                }
            }
        }
        return depth;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

