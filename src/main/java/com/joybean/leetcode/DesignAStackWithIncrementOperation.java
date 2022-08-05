package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/design-a-stack-with-increment-operation/">Design a Stack With Increment
 * Operation</a>
 *
 * @author Joybean
 */
public class DesignAStackWithIncrementOperation {
    private int[] stack;
    private int tail = -1;

    public DesignAStackWithIncrementOperation(int maxSize) {
        stack = new int[maxSize];
    }

    /**
     * using array
     * @param x
     */
    public void push1(int x) {
        if (tail + 1 == stack.length) {
            return;
        }
        stack[++tail] = x;
    }

    public int pop1() {
        if (tail == -1) {
            return -1;
        }
        return stack[tail--];
    }

    public void increment1(int k, int val) {
        for (int i = 0; i <= tail && i < k; i++) {
            stack[i] = stack[i] + val;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/design-a-stack-with-increment-operation/discuss/539716/JavaC%2B
     * %2BPython-Lazy-increment-O(1)">Lazy increment</a>
     * TODO
     *
     * @param x
     */
    public void push3(int x) {

    }
}
