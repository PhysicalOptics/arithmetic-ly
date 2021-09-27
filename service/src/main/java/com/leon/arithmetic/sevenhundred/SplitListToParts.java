package com.leon.arithmetic.sevenhundred;

import com.leon.util.ListNode;

/**
  * ClassName:    SplitListToParts
  * @Description: 725:分割链表
  * @Author:      liyang
  * @Date:        2021/9/22
  * version     1.0.0
 */
public class SplitListToParts {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        SplitListToParts splitListToParts = new SplitListToParts();
        splitListToParts.splitListToParts2(head,7);
    }

    public ListNode[] splitListToParts2(ListNode head, int k) {
        ListNode[] list = new ListNode[k];
        int length = 0;
        ListNode temp = head;
        while (temp !=null){
            temp = temp.next;
            length++;
        }
        int count = length/k,index=length%k;

        ListNode start = head;
        for (int i = 0; i < k; i++) {
            list[i] = start;
            if (start==null) continue;
            int t = count + (i < index ? 1 : 0);
            for (int j = 0; j < t-1; j++) {
                start = start.next;
            }
            ListNode next = start.next;
            start.next = null;
            start = next;
        }
        return list;


    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list = new ListNode[k];
        if (head==null){
            return list;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode temp = pre;
        int count = 0,index = k-1;
        while (temp.next!=null){
            for (int i = 0; i < k; i++) {
                temp = temp.next;
                if (temp.next==null){
                    index = i;
                    break;
                }
            }
            count++;
        }

        ListNode start = pre.next;
        for (int i = 0; i < k; i++) {

            ListNode subStart = start;
            if (i<=index){
                for (int j = 0; j < count-1; j++) {
                    subStart = subStart.next;
                }
                list[i] = start;
                start = subStart.next;
                subStart.next = null;
            }else {
                if (subStart == null){
                    list[i] = subStart;
                    continue;
                }
                for (int j = 0; j < count-2; j++) {
                    subStart = subStart.next;
                }
                list[i] = start;
                start = subStart.next;
                subStart.next = null;
            }
        }
        return list;

    }
}