package com.leon.arithmetic.dynamicprogram;






/**
  * ClassName:    RobTest
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/1/14
  * version     1.0.0
 */
public class RobTreeTest {
    public static int treeRob(TreeNode root){
        int max = Math.max(dfs(root)[0], dfs(root)[1]);
        return max;
    }

    public static int[] dfs(TreeNode root){
        if (root==null) return new int[]{0,0};
        int[] ldfs = dfs(root.left);
        int[] rdfs = dfs(root.right);
        int select = root.val+ldfs[1]+rdfs[1];
        int noselect = Math.max(ldfs[0],ldfs[1])+Math.max(rdfs[0],rdfs[1]);
        return new int[]{select,noselect};
    }
    
    public static void main(String[] args){
        int[] nums = {2, 7, 9, 3, 1};
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}