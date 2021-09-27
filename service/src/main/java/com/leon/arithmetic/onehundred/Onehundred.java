package com.leon.arithmetic.onehundred;

import com.leon.util.ListNode;

/**
  * ClassName:    Onehundred
  * @Description: 25
  * @Author:      liyang
  * @Date:        2021/3/12
  * version     1.0.0
 */
public class Onehundred {


    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode end = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                end = end.next;
                if (end == null) {
                    return hair.next;
                }
            }
//            ListNode nex = end.next;
            ListNode[] reverse = myReverse(head, end);
            head = reverse[0];
            end = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
//            end.next = nex;
            pre = end;
            head = end.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode end) {
        ListNode prev = end.next;
        ListNode cur = head;
        while (prev != end) {
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return new ListNode[]{end, head};
    }

//    ------------------
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre= dummy;
        ListNode end = dummy;
        while (end.next!=null){
            for (int i = 0; i < k && end.next != null; i++) {
                end = end.next;
            }
            if (end==null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            pre.next = reverse(start);
            start.next = next;
            // 标记住翻转链表的起手式
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null){
//            ListNode temp = cur.next;
//            cur.next = pre ;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;


//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        ListNode pre = dummy;
//        ListNode end = dummy;
//
//        while (end.next != null) {
//            for (int i = 0; i < k && end != null; i++) end = end.next;
//            if (end == null) break;
//            ListNode start = pre.next;
//            ListNode next = end.next;
//            end.next = null;
//            pre.next = reverse(start);
//            start.next = next;
//            pre = start;
//
//            end = pre;
//        }
//        return dummy.next;
    }
}