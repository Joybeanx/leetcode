package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 *
 * @author Joybean
 */
public class ReverseLinkedList {


    /**
     * Iterative solution: insert after dummy node
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    /**
     * Iterative solution: insert current node before head and make current node become new head (recommended)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tmp;
        }
        return newHead;
    }

    /**
     * Recursive solution: start from head, reverse the pointer between previous node and current node
     *
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ans = reverseList4(head, head.next);
        //head <—> n1 <— n2 ... <— tail
        head.next = null;
        return ans;
    }

    private static ListNode reverseList3(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return reverseList3(cur, next);
    }

    /**
     * Recursive solution: optimized version of reverseList4
     *
     * @param head
     * @return
     */
    public static ListNode reverseList4(ListNode head) {
        return reverseList4(null, head);
    }

    private static ListNode reverseList4(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return reverseList4(cur, next);
    }

    /**
     * Recursive solution (by labuladong): start from tail, reverse the pointer between previous node and current node
     *
     * @param head
     * @return
     */
    public static ListNode reverseList5(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //head.next become the tail of reversed list after each recursion
        //newHead must be the tail of original list
        ListNode newHead = reverseList5(head.next);
        head.next.next = head;
        //head <—> n1 <— n2 ... <— tail
        head.next = null;
        return newHead;
    }

    /**
     * Recursive solution: insert node after dummy node
     *
     * @param head
     * @return
     */
    public static ListNode reverseList6(ListNode head) {
        ListNode dummy = new ListNode(0, null);
        reverseList6(dummy, head);
        return dummy.next;
    }

    private static void reverseList6(ListNode dummy, ListNode cur) {
        if (cur == null) {
            return;
        }
        ListNode next = cur.next;
        cur.next = dummy.next;
        dummy.next = cur;
        reverseList6(dummy, next);
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
