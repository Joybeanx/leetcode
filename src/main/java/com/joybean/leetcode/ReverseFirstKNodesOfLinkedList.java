package com.joybean.leetcode;

/**
 * Reverse First K Nodes of Linked List
 *
 * @author Joybean
 */
public class ReverseFirstKNodesOfLinkedList {
    /**
     * Recursive solution 1
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKNodes1(ListNode head, int k) {
        return helper(head, 1, k);
    }

    private static ListNode helper(ListNode head, int pos, int k) {
        if (pos == k) {
            return head;
        }
        ListNode last = helper(head.next, ++pos, k);
        ListNode tmp = head.next.next;
        head.next.next = head;
        head.next = tmp;
        return last;
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
