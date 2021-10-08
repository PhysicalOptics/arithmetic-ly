package com.leon.arithmetic.twohundred;

import java.util.Stack;

/**
  * ClassName:    CQueue
  * @Description: 栈实现队列
  * @Author:      liyang
  * @Date:        2021/6/22
  * version     1.0.0
 */
public class CQueue {
    private Stack<Integer> inQueue;
    private Stack<Integer> outQueue;
    public CQueue() {
        this.inQueue = new Stack<Integer>();
        this.outQueue = new Stack<Integer>();
    }

    public void appendTail(int value) {
        this.inQueue.push(value);
    }

    public int deleteHead() {
        if(outQueue.isEmpty()){
            while(!inQueue.isEmpty()){
                outQueue.push(inQueue.pop());
            }
        }
        if(outQueue.isEmpty()){
            return -1;
        }else{
            return outQueue.pop();
        }


    }
}