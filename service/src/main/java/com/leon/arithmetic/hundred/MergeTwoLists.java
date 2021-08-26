package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    MergeTwoLists
  * @Description: 21
  * @Author:      liyang
  * @Date:        2021/5/12
  * version     1.0.0
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode(0);
        ListNode head = hair;
        while (l1!=null || l2!=null){
            if (l1==null){
                head.next = l2;
                head = head.next;
                l2 = l2.next;
                continue;
            }
            if (l2==null){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
                continue;
            }
            if (l1.val>l2.val){
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }
        return hair.next;
    }
}