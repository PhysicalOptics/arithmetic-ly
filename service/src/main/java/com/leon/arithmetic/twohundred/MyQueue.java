package com.leon.arithmetic.twohundred;

import java.util.Deque;
import java.util.Stack;

/**
  * ClassName:    MyQueue
  * @Description: 232
  * @Author:      liyang
  * @Date:        2021/3/5
  * version     1.0.0
 */
public class MyQueue {
    private Stack<Integer> inQueue;
    private Stack<Integer> outQueue;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.inQueue = new Stack<>();
        this.outQueue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.inQueue.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outQueue.isEmpty()){
            while (!inQueue.isEmpty()){
                outQueue.push(inQueue.pop());
            }
        }
        return outQueue.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(outQueue.isEmpty()){
            while (!inQueue.isEmpty()){
                outQueue.push(inQueue.pop());
            }
        }
        return outQueue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.inQueue.isEmpty()&&this.outQueue.isEmpty();
    }


}