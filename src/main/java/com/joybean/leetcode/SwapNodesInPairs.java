package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">Swap Nodes in Pairs</a>
 *
 * @author Joybean
 */
public class SwapNodesInPairs {
    /**
     * Recursive solution
     *
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = swapPairs1(second.next);
        second.next = head;
        return second;
    }

    /**
     * Iterative solution
     * TODO
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        return null;
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
