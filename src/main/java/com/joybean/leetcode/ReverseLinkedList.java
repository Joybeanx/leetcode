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
     * Iterative solution 2
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            head = head.next;
            cur.next = next;
            next = cur;
            cur = head;
        }
        return next;
    }

    /**
     * Recursive solution
     *
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        return helper(null, head);
    }

    private static ListNode helper(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return helper(cur, next);
    }

    /**
     * Recursive solution 2
     *
     * @param head
     * @return
     */
    public static ListNode reverseList4(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ans = helper2(head, head.next);
        head.next = null;
        return ans;
    }

    private static ListNode helper2(ListNode prev, ListNode cur) {
        if (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            return helper2(cur, next);
        }
        return prev;
    }

    /**
     * Recursive solution 3
     *
     * @param head
     * @return
     */
    public static ListNode reverseList5(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList5(head.next);
        head.next.next = head;
        head.next = null;
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
