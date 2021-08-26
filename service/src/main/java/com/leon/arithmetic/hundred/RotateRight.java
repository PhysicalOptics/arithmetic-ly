package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    RotateRight
  * @Description: 61
  * @Author:      liyang
  * @Date:        2021/3/29
  * version     1.0.0
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null||k==0) return head;
        ListNode curr = head;
        int l=1;
        while (curr.next!=null){
            curr = curr.next;
            l++;
        }
        int i = l-k % l;
        curr.next = head;

        while (i>0){
            curr = curr.next;
            i--;
        }
        ListNode ret = curr.next;
        curr.next= null;
        return ret;

    }
}