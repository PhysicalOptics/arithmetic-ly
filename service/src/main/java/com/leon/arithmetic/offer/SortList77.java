package com.leon.arithmetic.offer;

import com.leon.util.ListNode;

/**
  * ClassName:    SortList77
  * @Description: 77.链表排序
  * @Author:      liyang
  * @Date:        2021/9/24
  * version     1.0.0
 */
public class SortList77 {

    public static ListNode sortList(ListNode head) {
        ListNode pre = new ListNode();
        ListNode curr = head;
        while (curr!=null){
            ListNode next = pre.next;

            // next不为空，遍历找出位置插入
            ListNode tempPre = pre;
            while (next!=null){
                // 如果新链节点值大于curr则插入前面
                if (next.val>curr.val){
                    ListNode currNext = curr.next;
                    curr.next = next;
                    tempPre.next = curr;
                    curr = currNext;
                    break;
                }else {
                    // 如果新链节点小于curr，继续向后遍历
                    tempPre = next;
                    next = next.next;
                }
            }
            // next如果为空直接追加元素
            if (next==null){
                ListNode currNext = curr.next;
                curr.next = null;
                tempPre.next = curr;
                curr = currNext;
            }
        }
        return pre.next;
    }

    public static void main(String[] args){
        ListNode listNode = new ListNode(new int[]{4,2,1,3});
        sortList(listNode);
        System.out.println(listNode.toString());
    }
}