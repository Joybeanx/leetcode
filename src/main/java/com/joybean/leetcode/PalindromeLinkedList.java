package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">Palindrome Linked List</a>
 *
 * @author Joybean
 */
public class PalindromeLinkedList {
    //TODO
    public boolean isPalindrome(ListNode head) {
        return false;
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
