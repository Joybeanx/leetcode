package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Middle of the Linked List</a>
 *
 * @author Joybean
 */
public class MiddleOfTheLinkedList {
    /**
     * Fast and Slow Pointer
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
