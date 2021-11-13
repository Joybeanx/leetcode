package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/">Swapping Nodes in a Linked List</a>
 *
 * @author Joybean
 */
public class SwappingNodesInALinkedList {
    public static ListNode swapNodes1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode first = fast;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode second = slow;
        int val1 = first.val;
        first.val = second.val;
        second.val = val1;
        return head;
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
