package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    RemoveNthFromEnd19
  * @Description: 19. 删除链表倒数第n个节点
  * @Author:      liyang
  * @Date:        2021/10/19
  * version     1.0.0
 */
public class RemoveNthFromEnd19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode fast = hair;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = hair;
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode last = slow.next.next;
        slow.next = last;
        return slow;
    }
}