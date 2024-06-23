package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/rotate-list/">Rotate List</a>
 *
 * @author Joybean
 */
public class RotateList {
    /**
     * Two pointers
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        ListNode fast = head;
        ListNode slow = head;
        k %= length;
        if (k == 0) {
            return head;
        }
        while (k-- > 0) {
            fast = fast.next;
        }
        ListNode tail = null;
        ListNode prev = null;
        while (fast != null) {
            tail = fast;
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        ListNode newHead = slow;
        tail.next = head;
        return newHead;
    }

    /**
     * <a href="https://leetcode.com/problems/rotate-list/solutions/22827/java-clean-solution-only-one-pointer-used
     * /">One pointer: Make a circle first</a>
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        //make it a circle here rather than below
        tail.next = head;
        ListNode newHead = head;
        ListNode newTail = head;
        for (int i = 0; i < length - k % length; i++) {
            newTail = newHead;
            newHead = newHead.next;

        }
        //if we put "end.next = head;" here, we cannot pass the case: [1], 1
        //break the circle
        newTail.next = null;
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
