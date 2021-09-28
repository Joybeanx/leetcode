package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 *
 * @author Joybean
 */
public class ReverseLinkedList {
    /**
     * Iterative solution
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = next;
            next = cur;
            cur = tmp;
        }
        return next;
    }

    /**
     * Recursive solution
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ans = helper(head, head.next);
        head.next = null;
        return ans;
    }

    private static ListNode helper(ListNode prev, ListNode cur) {
        if (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            return helper(cur, next);
        }
        return prev;
    }

    public class ListNode {
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
