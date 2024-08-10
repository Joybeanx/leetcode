package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in k-Group</a>
 *
 * @author Joybean
 */
public class ReverseNodesInKGroup {
    /**
     * Recursive solution (by labuladong)
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        for (int i = 1; i <= k; i++) {
            if (right == null) {
                return head;
            }
            right = right.next;
        }
        ListNode newHead = reverseBetween(left, right);
        left.next = reverseKGroup1(right, k);
        return newHead;
    }

    private static ListNode reverseBetween(ListNode left, ListNode right) {
        ListNode cur = left;
        ListNode newHead = null;
        while (cur != right) {
            ListNode tmp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tmp;
        }
        return newHead;
    }

    /**
     * Recursive solution: reverse first k and then append subsequent reversed head
     *
     * @param head
     * @param k
     * @return
     */

    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode cur = head;
        int n = 0;
        while (n != k && cur != null) {
            cur = cur.next;
            n++;
        }
        if (n < k) {
            return head;
        }
        ListNode reversed = reverseKGroup2(cur, k);
        ListNode dummy = new ListNode(0);
        while (head != cur) {
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        head.next = reversed;
        return dummy.next;
    }

    /**
     * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/11423/short-but-recursive-java-code
     * -with-comments/">Optimized recursive solution</a>
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup3(ListNode head, int k) {
        ListNode cur = head;
        int n = 0;
        while (cur != null && n != k) {
            cur = cur.next;
            n++;
        }
        if (n < k) {
            return head;
        }
        ListNode newHead = reverseKGroup2(cur, k);
        while (n-- > 0) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    /**
     * Iterative solution
     * TODO
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup4(ListNode head, int k) {
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
