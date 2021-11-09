package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">Reverse Linked List II</a>
 *
 * @author Joybean
 */
public class ReverseLinkedList2 {
    /**
     * Iterative solution
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        int curPos = 1;
        ListNode reversedTail = head;
        ListNode predecessor = null;
        while (curPos < left) {
            predecessor = reversedTail;
            reversedTail = reversedTail.next;
            curPos++;
        }
        ListNode cur = reversedTail;
        ListNode reversedHead = null;
        ListNode suffix = reversedTail.next;
        while (curPos <= right) {
            suffix = cur.next;
            cur.next = reversedHead;
            reversedHead = cur;
            cur = suffix;
            curPos++;
        }
        reversedTail.next = suffix;
        if (predecessor == null) {
            return reversedHead;
        }
        predecessor.next = reversedHead;
        return head;
    }

    /**
     * Recursive solution
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        int curPos = 1;
        ListNode predecessor = null;
        ListNode cur = head;
        while (curPos++ < left) {
            predecessor = cur;
            cur = cur.next;
        }
        ListNode reverseStart = head;
        if (predecessor != null) {
            reverseStart = predecessor.next;
        }
        ListNode reversed = reverseFirstKNodes(reverseStart, right - left + 1);
        if (predecessor == null) {
            return reversed;
        }
        predecessor.next = reversed;
        return head;
    }

    /**
     * Recursive solution 2 (from labuladong)
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween3(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseFirstKNodes(head, right);
        }
        head.next = reverseBetween3(head.next, left - 1, right - 1);
        return head;
    }

    /**
     * @param head
     * @param k
     * @return
     * @see ReverseFirstKNodesOfLinkedList#reverseKNodes1
     */
    private static ListNode reverseFirstKNodes(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode newHead = reverseFirstKNodes(head.next, --k);
        //The (k+1)th node
        ListNode unchanged = head.next.next;
        head.next.next = head;
        head.next = unchanged;
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
