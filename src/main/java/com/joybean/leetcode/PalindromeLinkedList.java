package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">Palindrome Linked List</a>
 *
 * @author Joybean
 */
public class PalindromeLinkedList {
    public static boolean isPalindrome1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode leftHead = reverseLeftHalf(head, slow);
        //When linked list has odd nodes,let right half smaller so that the two halves have same length
        //for example [1,3,1], slow pointer will stop at 3
        ListNode rightHead = slow;
        if (fast != null) {
            rightHead = slow.next;
        }
        while (rightHead != null && leftHead != null) {
            if (rightHead.val != leftHead.val) {
                return false;
            }
            rightHead = rightHead.next;
            leftHead = leftHead.next;
        }
        return true;
    }

    private static ListNode reverseLeftHalf(ListNode from, ListNode to) {
        ListNode newHead = null;
        while (from != to) {
            ListNode tmp = from.next;
            from.next = newHead;
            newHead = from;
            from = tmp;
        }
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
