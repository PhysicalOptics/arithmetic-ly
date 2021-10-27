package com.leon.arithmetic.sixhundred;

import com.leon.util.TreeNode;

/**
  * ClassName:    MergeTrees617
  * @Description: 617. 合并二叉树
  * @Author:      liyang
  * @Date:        2021/10/21
  * version     1.0.0
 */
public class MergeTrees617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        TreeNode dest = new TreeNode(root1.val + root2.val);
        dest.left = mergeTrees(root1.left,root2.left);
        dest.right = mergeTrees(root1.right,root2.right);
        return dest;
    }

    // 对象的引用分析异常
    //public TreeNode merge(TreeNode root1, TreeNode root2){
    //    TreeNode temp = root1;
    //    if (root1==null&&root2==null) return temp;
    //    if (root1==null){
    //        return root2;
    //    }else if (root2==null){
    //        return root1;
    //    }
    //
    //    temp.val =root1.val+root2.val;
    //    temp.left = mergeTrees(root1.left,root2.left);
    //    temp.right =mergeTrees(root1.right,root2.right);
    //
    //    return temp;
    //}


    public static void main(String[] args){
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        if (b1&&b2){
            System.out.println(12);
        }else if (!b1&&(b2||b3)){
            System.out.println(111);
        }
    }

}