package com.leon.arithmetic.onehundred;

import com.leon.util.ListNode;

/**
  * ClassName:    InsertionSortList147
  * @Description: 147. 链表插入排序
  * @Author:      liyang
  * @Date:        2021/12/8
  * version     1.0.0
 */
public class InsertionSortList147 {

    // 记录尾结点，判断是否插入队尾
    public ListNode insertionSortList2(ListNode head) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode curr = head.next;
        ListNode last = head;
        while (curr!=null){
            if (curr.val>last.val){
                last = last.next;
            }else {
                ListNode pre = hair;
                while (pre.next!=null && pre.next.val<curr.val){
                    pre=pre.next;
                }
                last.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = last.next;
        }
        return hair.next;
    }

    // 直接从头遍历到尾，寻址插入
    public ListNode insertionSortList(ListNode head) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode curr = head.next;
        head.next = null;
        while (curr!=null){
            ListNode pre = hair;
            while (pre.next!=null && pre.next.val<curr.val){
                pre = pre.next;
            }
            // 如果遍历到最后节点，则直接插入链表尾
            if (pre.next==null){
                ListNode next = curr.next;
                curr.next = null;
                pre.next = curr;
                curr = next;
            }else {// 链表中间则直接插入
                ListNode next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
                curr = next;
            }
        }
        return hair.next;
    }
}