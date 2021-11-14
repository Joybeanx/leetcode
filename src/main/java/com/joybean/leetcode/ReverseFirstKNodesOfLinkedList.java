package com.joybean.leetcode;

/**
 * Reverse First K Nodes of Linked List
 *
 * @author Joybean
 */
public class ReverseFirstKNodesOfLinkedList {
    private static ListNode successor;

    /**
     * Recursive solution
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKNodes1(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode newHead = reverseKNodes1(head.next, --k);
        //The (k+1)th node
        ListNode unchanged = head.next.next;
        head.next.next = head;
        head.next = unchanged;
        return newHead;
    }

    /**
     * Recursive solution 2 (by labuladong)
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKNodes2(ListNode head, int k) {
        if (k == 1) {
            successor = head.next;
            return head;
        }
        ListNode newHead = reverseKNodes2(head.next, --k);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }

    /**
     * Iterative solution
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKNodes3(ListNode head, int k) {
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null && k-- > 0) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        head.next = cur;
        return newHead;
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
