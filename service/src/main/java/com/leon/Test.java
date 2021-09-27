package com.leon;

import com.leon.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
  * ClassName:    Test
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/8/19
  * version     1.0.0
 */
public class Test {

    public static void main(String[] args){
        String s= "2021-09-16 13:15:00";

        System.out.println(s.substring(0,19));
//        System.out.println("京东方UATP卡号及各分公司担当联系方式".toLowerCase().contains("uatp".toLowerCase()));
    }

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