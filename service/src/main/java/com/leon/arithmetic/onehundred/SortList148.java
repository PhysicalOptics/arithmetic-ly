package com.leon.arithmetic.onehundred;

import com.leon.util.ListNode;

/**
  * ClassName:    SortList148
  * @Description: 148. 归并排序链表
  * @Author:      liyang
  * @Date:        2021/12/8
  * version     1.0.0
 */
public class SortList148 {

    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                //将分拆之后合并的链表归一，以便在<<1加大间隔时重新拆分
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }










    // 法一 空间递归占用log2n
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    public ListNode sort(ListNode head){
        if (head==null||head.next==null){// 小于等于1个节点
            return head;
        }
        ListNode hair = new ListNode();
        hair.next = head;

        ListNode fast = hair,slow= hair;
        int i = 0;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            i++;
        }
        if (i>1){// 大于两个节点
            ListNode after = slow.next;
            slow.next = null;
            ListNode sort1 = sort(hair.next);
            ListNode sort2 = sort(after);
            return merge(sort1,sort2);
        }else {// 2个节点
            if (head.val>head.next.val){
                hair.next = head.next;
                head.next = null;
                hair.next.next = head;
            }
            return hair.next;
        }

    }

    public ListNode merge(ListNode node1,ListNode node2){
        ListNode hair = new ListNode();
        ListNode head = hair;
        while (node1!=null||node2!=null){
            if (node1==null){
                head.next = node2;
                break;
            }
            if (node2==null){
                head.next = node1;
                break;
            }
            if (node1.val>node2.val){
                head.next = node2;
                node2 = node2.next;

            }else {
                head.next = node1;
                node1=node1.next;
            }
            head = head.next;
        }
        return hair.next;
    }
}