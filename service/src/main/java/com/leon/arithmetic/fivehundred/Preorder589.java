package com.leon.arithmetic.fivehundred;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    Preorder589
  * @Description: 589. N叉树的前序遍历
  * @Author:      liyang
  * @Date:        2022/3/10
  * version     1.0.0
 */
public class Preorder589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    public void dfs(Node root,List<Integer> list){
        if (root==null) return;
        list.add(root.val);
        for (Node child : root.children) {
            dfs(child,list);
        }
    }
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