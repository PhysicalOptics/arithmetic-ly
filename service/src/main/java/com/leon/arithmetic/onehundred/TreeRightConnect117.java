package com.leon.arithmetic.onehundred;


import java.util.LinkedList;

/**
  * ClassName:    TreeRightConnect117
  * @Description: 117. 填充树的每一个右节点
  * @Author:      liyang
  * @Date:        2021/12/14
  * version     1.0.0
 */
public class TreeRightConnect117 {

    public Node connect(Node root){
        if (root==null) return root;
        Node curr = root;
        while (curr!=null){
            //遍历这一层的时候，开始组装下一层
            Node downpre = new Node(0);
            Node pre = downpre;
            while (curr!=null){
                if (curr.left!=null){
                    pre.next = curr.left;
                    pre = pre.next;
                }
                if (curr.right!=null){
                    pre.next = curr.right;
                    pre = pre.next;
                }
                curr=curr.next;
            }
            curr = downpre.next;
        }
        return root;
    }
}

class Node {
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
};
