package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 *
 * @author Joybean
 */
public class MinStack {
    private Node head;

    /**
     * <a href="https://leetcode.com/problems/min-stack/solutions/49010/clean-6ms-java-solution/">Associate every node with min value</a>
     */
    public MinStack() {
        head = new Node(null, Integer.MAX_VALUE, null);
    }

    public void push(int val) {
        head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
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
