package com.leon.arithmetic.hundred;

import com.leon.arithmetic.util.ListNode;

/**
  * ClassName:    DetectCycle
  * @Description: 142
  * @Author:      liyang
  * @Date:        2021/7/22
  * version     1.0.0
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow=head;
        boolean cycle = false;
        while (fast!=null&&slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                cycle =true;
                break;
            }
        }
        slow = head;
        if (cycle){
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
                if (slow == fast) return slow;
            }
        }else {
            return null;
        }
        return null;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head,fast =head;
        for (int i = 0; i < k-1; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast= fast.next;
            slow = slow.next;
        }
        return slow;
    }
}