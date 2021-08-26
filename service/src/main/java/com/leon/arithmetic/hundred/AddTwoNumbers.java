package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    AddTwoNumbers
  * @Description: 2
  * @Author:      liyang
  * @Date:        2021/3/19
  * version     1.0.0
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode start = head;
        int up = 0;
        while (l1 != null || l2 != null){
            int a = l1==null?0:l1.val;
            int b = l2==null?0:l2.val;
            int sum = a+b+up;
            ListNode t = new ListNode(0);
            if (sum>=10){
                t.val = sum-10;
                up = 1;
            }else {
                t.val = sum;
                up = 0;
            }
            start.next = t;
            start = t;
            l1=l1!=null?l1.next:l1;
            l2=l2!=null?l2.next:l2;

        }
        if (up>0){
            start.next = new ListNode(up);
        }
        return head.next;

    }
    
    public static void main(String[] args){
        ListNode h1 = new ListNode(9);
        h1.next = new ListNode(9);
        h1.next.next = new ListNode(9);
        ListNode h2 = new ListNode(9);
        h2.next = new ListNode(9);
        h2.next.next = new ListNode(9);
        h2.next.next.next = new ListNode(9);
        h2.next.next.next.next = new ListNode(9);
        addTwoNumbers(h1,h2);
    }
}