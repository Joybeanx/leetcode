package com.joybean.leetcode;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/linked-list-random-node/">Linked List Random Node</a>
 *
 * @author Joybean
 */
public class LinkedListRandomNode {
    private ListNode head;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        Random random = new Random();
        int result = -1;
        ListNode current = head;
        int i = 1;
        while (current != null) {
            if (random.nextInt(i) == 0){
                result = current.val;
            }
            current = current.next;
            i++;
        }
        return result;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
