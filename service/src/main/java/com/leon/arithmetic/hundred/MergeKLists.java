package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    MergeKLists
  * @Description: 23
  * @Author:      liyang
  * @Date:        2021/5/13
  * version     1.0.0
 */
public class MergeKLists {
    public static void main(String[] args){
        // 1,4,5
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        // 1,3,4
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        // 2,6
        ListNode listNode3 = new ListNode(2);
        listNode2.next = new ListNode(6);
        MergeKLists mergeKLists = new MergeKLists();
        ListNode[] listNodes = {listNode1, listNode2, listNode3};
        mergeKLists.mergeKLists(listNodes);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        while (lists.length>1){
            ListNode[] listNodes = new ListNode[(lists.length + 1) / 2];
            for (int i = 0; i < lists.length; i++) {
                if (i%2==0&& i!=lists.length-1){
                    listNodes[i/2] = merge(lists[i],lists[i+1]);
                }else if (i%2==0 && i==lists.length-1){
                    listNodes[listNodes.length-1] = lists[i];
                }
            }
            lists = listNodes;
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode hair = new ListNode(0);
        ListNode head = hair;
        while (l1!=null || l2!=null){
            if (l1==null){
                head.next = l2;
                head = head.next;
                l2 = l2.next;
                continue;
            }
            if (l2==null){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
                continue;
            }
            if (l1.val>l2.val){
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }
        return hair.next;
    }
}