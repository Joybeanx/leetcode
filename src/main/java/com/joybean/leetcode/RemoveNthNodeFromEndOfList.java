package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Remove Nth Node From End of List</a>
 *
 * @author Joybean
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Fast and Slow Pointer
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        int step = n;
        while (fast != null) {
            fast = fast.next;
            if (--step == 0) {
                break;
            }
        }
        ListNode slow = head;
        ListNode prev = dummy;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return dummy.next;
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
