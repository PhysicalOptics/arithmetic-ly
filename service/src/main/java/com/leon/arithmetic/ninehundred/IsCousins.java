package com.leon.arithmetic.ninehundred;

import com.leon.util.TreeNode;

/**
  * ClassName:    IsCousins
  * @Description: 993
  * @Author:      liyang
  * @Date:        2021/5/17
  * version     1.0.0
 */
public class IsCousins {
    int xd = -1,yd=-1;
    public boolean isCousins(TreeNode root, int x, int y) {
        bts(root,x,y,0);
        return xd==yd;
    }

    public void bts(TreeNode root,int x,int y,int deep){
        if (root == null || (xd==yd&&xd!=-1)) return;
        deep++;
        if (x==root.val) xd = deep;
        if (y==root.val) yd = deep;
        bts(root.left ,x,y,deep);
        bts(root.right ,x,y,deep);
        deep--;
    }
}