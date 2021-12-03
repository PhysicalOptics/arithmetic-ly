package com.leon.arithmetic.twohundred;

import com.leon.util.ListNode;

/**
  * ClassName:    ReverseList206
  * @Description: 206. 反转链表
  * @Author:      liyang
  * @Date:        2021/11/11
  * version     1.0.0
 */
public class ReverseList206 {

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next= null;
        return newhead;
    }
}