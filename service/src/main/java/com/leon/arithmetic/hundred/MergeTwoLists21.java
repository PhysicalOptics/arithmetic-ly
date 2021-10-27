package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    MergeTwoLists21
  * @Description: 21. 合并两个有序列表
  * @Author:      liyang
  * @Date:        2021/10/26
  * version     1.0.0
 */
public class MergeTwoLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode();
        ListNode head = hair;
        while (l1!=null|| l2!=null){
            if (l1==null){
                head.next = l2;
                break;
            }else if (l2==null){
                head.next = l1;
                break;
            }else if (l1.val>l2.val){
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }else {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }
        }
        return hair.next;
    }
    public ListNode mergeTwoListscuo(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode();
        ListNode head;
        if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }else if (l1.val>l2.val){
            head = l2;
            l2 = l2.next;
        }else {
            head = l1;
            l1 = l1.next;
        }
        hair.next = head;
        while (l1!=null&& l2!=null){
            if (l1.val>l2.val){
                head.next = l2;
                l2=l2.next;
            }else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        return hair.next;
    }
}