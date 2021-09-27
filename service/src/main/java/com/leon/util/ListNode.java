package com.leon.util;

/**
  * ClassName:    ListNode
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/3/19
  * version     1.0.0
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int[] val) {
        this.val = val[0];
        ListNode curr = this;
        for (int i = 1; i < val.length; i++) {
            ListNode next = new ListNode(val[i]);
            curr.next = next;
            curr = curr.next;
        }
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}