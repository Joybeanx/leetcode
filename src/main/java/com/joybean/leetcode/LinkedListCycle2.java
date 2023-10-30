package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Linked List Cycle II</a>
 *
 * @author Joybean
 */
public class LinkedListCycle2 {
    /**
     * Floyd's cycle detection algorithm
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}
