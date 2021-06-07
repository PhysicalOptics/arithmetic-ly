package com.leon.arithmetic.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
  * ClassName:    MinStack
  * @Description: 155
  * @Author:      liyang
  * @Date:        2021/2/20
  * version     1.0.0
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
        stack.pop();
        minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}