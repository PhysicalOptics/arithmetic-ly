package com.leon.arithmetic.hundred;

import javafx.beans.binding.When;

/**
  * ClassName:    ReverseBetween
  * @Description: 92
  * @Author:      liyang
  * @Date:        2021/3/18
  * version     1.0.0
 */
public class ReverseBetween {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args){
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode head = new ListNode();
        head.val = 1;
        int i = 1;
        ListNode s = head;
        while (i<2){
            i++;
            ListNode t = new ListNode();
            t.val = i;
            s.next = t;
            s = t;
        }
        reverseBetween.reverseBetween(head,1,2);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next==null||left == right){
            return head;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (left>1){
            pre = pre.next;
            left--;
        }
        ListNode end = head;
        while (right>1){
            end = end.next;
            right--;
        }
        pre.next= reverse(pre.next, end);
        return hair.next;

    }

    public ListNode reverse(ListNode start,ListNode end){
        ListNode last = end.next;
        ListNode curr = start;
        while (last != end){
            ListNode next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        return last;
    }


}

class ParkingSystem {
    private int big;
    private int medium;
    private int small;


    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                if (this.big>0){
                    this.big--;
                }else {
                    return false;
                }
            case 2:
                if (this.medium>0){
                    this.medium--;
                }else {
                    return false;
                }
            case 3:
                if (this.small>0){
                    this.small--;
                }else {
                    return false;
                }
        }
        return true;
    }
}
