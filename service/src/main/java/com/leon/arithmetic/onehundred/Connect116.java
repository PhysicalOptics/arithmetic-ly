package com.leon.arithmetic.onehundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    Connect116
  * @Description: 116. 填充右侧节点
  * @Author:      liyang
  * @Date:        2021/10/26
  * version     1.0.0
 */
public class Connect116 {
    public static void main(String[] args){
        //ArrayList<Integer> list = new ArrayList<>();
        //list.add(new Integer(23));
        //list.add(new Integer(212332));
        //Integer integer = new Integer(212332);
        //System.out.println(list.contains(integer));
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect(root);

    }

    // 一层层按链表形式链接起来遍历
    public static Node connect2(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }

    public static Node connect(Node root) {
        if (root==null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (i<size-1){
                    poll.next = queue.peek();
                }
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}