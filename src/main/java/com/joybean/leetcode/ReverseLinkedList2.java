package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">Reverse Linked List II</a>
 *
 * @author Joybean
 */
public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        ListNode reversedTail = head;
        ListNode prefix = null;
        while (index < left) {
            prefix = reversedTail;
            reversedTail = reversedTail.next;
            index++;
        }
        ListNode cur = reversedTail;
        ListNode reversedHead = null;
        ListNode suffix = reversedTail.next;
        while (index <= right) {
            suffix = cur.next;
            cur.next = reversedHead;
            reversedHead = cur;
            cur = suffix;
            index++;
        }
        reversedTail.next = suffix;
        if (prefix == null) {
            return reversedHead;
        }
        prefix.next = reversedHead;
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
