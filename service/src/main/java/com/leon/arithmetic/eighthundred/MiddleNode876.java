package com.leon.arithmetic.eighthundred;

import com.leon.util.ListNode;

/**
  * ClassName:    MiddleNode876
  * @Description: 876. 寻找链表中间节点
  * @Author:      liyang
  * @Date:        2021/10/19
  * version     1.0.0
 */
public class MiddleNode876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}