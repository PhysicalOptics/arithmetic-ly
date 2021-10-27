package com.leon.arithmetic.onehundred;

import java.util.ArrayList;
import java.util.LinkedList;

/**
  * ClassName:    Connect116
  * @Description: 116. 填充右侧节点
  * @Author:      liyang
  * @Date:        2021/10/26
  * version     1.0.0
 */
public class Connect116 {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Integer(23));
        list.add(new Integer(212332));
        Integer integer = new Integer(212332);
        System.out.println(list.contains(integer));
        //Node root = new Node(1);
        //root.left = new Node(2);
        //root.right = new Node(3);
        //connect(root);

    }

    public static Node connect(Node root) {
        if (root==null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (queue.size()==0){
                    poll.next = null;
                }else {
                    Node peek = queue.peek();
                    poll.next = peek;
                }
                if (poll.left!=null){
                    queue.offer(poll.next);
                }
                if (poll.right!=null){
                    queue.offer(poll.next);
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