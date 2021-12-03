package com.leon.arithmetic.hundred;

import com.leon.util.ListNode;

/**
  * ClassName:    DeleteDuplicates82
  * @Description: 82. 删除重复元素
  * @Author:      liyang
  * @Date:        2021/12/3
  * version     1.0.0
 */
public class DeleteDuplicates82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;

        while (pre.next!=null&&pre.next.next!=null){
            if (pre.next.val == pre.next.next.val) {
                int temp = pre.next.val;
                ListNode nnext = pre.next.next;
                while (nnext.next != null && nnext.next.val == temp) {
                    nnext = nnext.next;
                }
                pre.next = nnext.next;
            }else {
                pre = pre.next;
            }

        }
        return hair.next;

    }

}