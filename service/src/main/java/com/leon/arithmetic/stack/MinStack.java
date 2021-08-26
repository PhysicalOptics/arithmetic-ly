package com.leon.arithmetic.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Vector;

/**
  * ClassName:    MinStack
  * @Description: 155
  * @Author:      liyang
  * @Date:        2021/2/20
  * version     1.0.0
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack(){
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x){
        stack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop(){
        if (stack.size()>0){
            stack.pop();
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println(-1%4);
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.pop();
//        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}