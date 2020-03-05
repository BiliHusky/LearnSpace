package com.yjw.interview.alg.leetcode;

import java.util.Stack;

/**
 * @author David Yang
 * @date 2020-02-22 15:00
 */
public class offer009 {
    public static void main(String[] args) {

        CQueue obj = new CQueue();
//        obj.appendTail(1);
//        obj.appendTail(2);
//        obj.appendTail(3);
//        obj.appendTail(4);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }
}

class CQueue {

    Stack<Integer> stack1; //head on the top
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        stack2.add(value);

        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
        }
    }

    public int deleteHead() {
        if (!stack1.isEmpty())
            return stack1.pop();
        else
            return -1;
    }
}