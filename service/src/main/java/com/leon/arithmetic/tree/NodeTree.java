package com.leon.arithmetic.tree;

import com.leon.util.TreeNode;

import java.util.*;

/**
  * ClassName:    NodeTree
  * @Description: 二叉树node
  * @Author:      liyang
  * @Date:        2020/8/17
  * version     1.0.0
 */

public class NodeTree<T> {
    public int treeHeight=0;
    class Node<T>{
        public Node left;//左子树
        public Node right;//右子树
        public T data;
        public int height;

        //二叉树的每个节点
        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
        public Node(){}
    }
    private Node root = null;
    private int size = 0;

    /**
     * 创建二叉树的根节点
     * @param value 根节点的值
     */
    public void createRoot(T value){
        if(value == null){
            throw new RuntimeException("头节点为空");
        }
        Node<T> newNode = new Node<T>(value);
        this.root = newNode;
        treeHeight = 1;
        size++;
    }
    /**
     * 获取根节点
     * @return 返回根节点root
     */
    public Node getRoot(){
        if(root == null){
            throw new RuntimeException("头节点为空");
        }
        return this.root;
    }
    /**
     * 判断二叉树是否为空
     * @return
     */
    public boolean isEmpty(){
        return root==null;
    }
    /**
     * 返回二叉树中元素的个数
     * @return
     */
    public int size(){
        return size;
    }
    /**
     * 添加节点
     * @param n 父节点
     * @param value 添加节点的元素值
     * @param left 是否为左节点
     * @return 返回添加的新节点
     */
    public Node add(Node<T> n,T value,boolean left){
        if(value == null){
            throw new RuntimeException("子节点为空");
        }
        if(n == null){
            throw new RuntimeException("父节点为空");
        }
        Node<T> newNode = new Node<T>(value);
        newNode.height = n.height+1;
        if (newNode.height>treeHeight){
            treeHeight = newNode.height;
        }
        if(left){
            if(n.left!=null){
                throw new RuntimeException("已有左子节点");
            }
            n.left = newNode;
            size++;
            return newNode;
        }
        else{
            if(n.right!=null){
                throw new RuntimeException("已有右子节点");
            }
            n.right = newNode;
            size++;
            return newNode;
        }

    }
    /**
     * 返回树的深度
     * @return
     */
    public int height() {
//        return height(root);
        return treeHeight;
    }

    // 先序遍历
    public void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            list.add(pop.val);
            if (pop.left!=null) queue.push(pop.left);
            if (pop.right!=null) queue.push(pop.right);

        }
    }
    
    // 中序遍历
    public void infixOrder(Node node) {
        if (node == null) {
            return;
        }
        infixOrder(node.left);
        System.out.println(node.data);
        infixOrder(node.right);
    }

    public void infixOrder2(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
    }
    // 后序遍历
    public void afterOrder(Node node) {
        if(node == null) {
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.data);
    }

    public void afterOrder2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            if (pop.left!=null) queue.push(pop.left);
            if (pop.right!=null) queue.push(pop.right);
            list.add(pop.val);

        }
    }
    public static void main(String args[]){
        NodeTree<String> nt = new NodeTree<String>();
        /**
         *                  根节点
         *   第二层左节点               第二层右节点
         *         第三层右节点    第三层左节点
         *     第四层左节点
         */
        nt.createRoot("根节点");
        NodeTree.Node nt2 = nt.add(nt.root, "第二层左节点", true);
        NodeTree.Node nt3 = nt.add(nt.root, "第二层右节点", false);
        NodeTree.Node nt4 = nt.add(nt2, "第三层右节点", false);
        NodeTree.Node nt7 = nt.add(nt2, "第三层左节点", true);
//        NodeTree.Node nt8 = nt.add(nt7, "第四层右节点", false);
        NodeTree.Node nt5 = nt.add(nt3, "第三层左节点", true);
        NodeTree.Node nt9 = nt.add(nt3, "第三层右节点", false);
        System.out.println("树的高度： " + nt.height());
//        NodeTree.Node nt6 = nt.add(nt4, "第四层左节点", true);
        System.out.println("树的高度： " + nt.height());
        System.out.println("元素个数： " + nt.size());

        nt.infixOrder(nt.root);

    }


}
