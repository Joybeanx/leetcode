package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/design-circular-queue/">Design Circular Queue</a>
 *
 * @author Joybean
 */
public class DesignCircularQueue {
    private int[] items;
    private int head;
    private int tail;

    public DesignCircularQueue(int k) {
        items = new int[k + 1];
    }

    public boolean enQueue1(int value) {
        if (isFull1()) {
            return false;
        }
        items[tail] = value;
        tail = (tail + 1) % items.length;
        return true;
    }

    public boolean deQueue1() {
        if (isEmpty1()) {
            return false;
        }
        items[head] = 0;
        head = (head + 1) % items.length;
        return true;
    }

    public int Front1() {
        if (isEmpty1()) {
            return -1;
        }
        return items[head];
    }

    public int Rear1() {
        if (isEmpty1()) {
            return -1;
        }
        return items[(tail + items.length - 1) % items.length];
    }

    public boolean isEmpty1() {
        return head == tail;
    }

    public boolean isFull1() {
        return (tail + 1) % items.length == head;
    }

    /**
     * <a href="https://leetcode.com/problems/design-circular-queue/discuss/149420/Concise-Java-using-array">maintaining
     * current quantity of items in queue </a>
     * TODO
     *
     * @param value
     * @return
     */
    public boolean enQueue2(int value) {

    }

}
