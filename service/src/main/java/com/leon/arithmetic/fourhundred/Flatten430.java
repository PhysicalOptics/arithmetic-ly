package com.leon.arithmetic.fourhundred;

import com.leon.util.Node;

/**
  * ClassName:    Flatten430
  * @Description: 扁平化多级双向链表430
  * @Author:      liyang
  * @Date:        2021/9/24
  * version     1.0.0
 */
public class Flatten430 {

    public Node flatten2(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node head){
        Node last = head;
        while (head!=null){
            if (head.child==null) {
                last = head;
                head = head.next;
            }else {
                Node next = head.next;
                // 直接获取child的最后一个节点
                Node dfs = dfs(head.child);
                // 断开child节点使之成为next节点
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                // 最后一个节点连接之前head的next节点
                dfs.next = next;
                if (next!= null) next.prev = dfs;
                // 继续向后循环，更换head和last
                last = dfs;
                head = dfs.next;
            }
        }
        return last;
    }


    // 法一
    public Node flatten(Node head) {
        Node hair = new Node(0);
        hair.next = head;
        while (head!=null){
            if (head.child == null) head = head.next;
            else {
                Node next = head.next;
                Node flatten = flatten(head.child);
                head.next = flatten;
                flatten.prev = head;
                head.child = null;
                while (head.next!=null) head = head.next;
                head.next = next;
                if (next!=null) next.prev = head;
                head = next;
            }
        }
        return hair.next;
    }



}