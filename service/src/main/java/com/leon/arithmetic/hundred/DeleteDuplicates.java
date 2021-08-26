package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    DeleteDuplicates
  * @Description: 83
  * @Author:      liyang
  * @Date:        2021/3/26
  * version     1.0.0
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (pre.next!=null && pre.next.next!=null){
            if (pre.next.val == pre.next.next.val){
                int x = pre.next.val;
                while (pre.next!=null&& pre.next.val == x){
                    pre.next = pre.next.next;
                }
            }else {
                pre = pre.next;
            }
        }
        return hair.next;
    }
}