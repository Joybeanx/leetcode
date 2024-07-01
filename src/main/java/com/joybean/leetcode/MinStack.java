package com.joybean.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 *
 * @author Joybean
 */
public class MinStack {

    /**
     * <a href="https://leetcode.com/problems/min-stack/solutions/49010/clean-6ms-java-solution/">Associate every node
     * with min value</a>
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

        head = new Node(null, Integer.MAX_VALUE, null);
    }

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public void push1(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }

        head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop1() {
        stack.pop();
        minStack.pop();
    }

    public int top1() {
        return stack.peek();
    }

    public int getMin1() {
        return minStack.peek();
    }


    //TODO use one stack: https://leetcode.com/problems/min-stack/solutions/49014/java-accepted-solution-using-one-stack/
    private int min;

    public void push2(int val) {

    }

    public void pop2() {

    }

    public int top2() {
        return 0;
    }

    public int getMin2() {
        return 0;
    }

    private Node head;

    public void push3(int val) {
        head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop3() {
        head = head.next;
    }

    public int top3() {
        return head.value;
    }

    public int getMin3() {
        return head.min;
    }

    private static class Node {
        private Integer value;
        private Integer min;
        private Node next;

        public Node(Integer value, Integer min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }
}
