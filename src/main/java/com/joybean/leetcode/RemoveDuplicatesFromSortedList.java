package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove Duplicates from Sorted List</a>
 *
 * @author Joybean
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Iterative solution
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;
        ListNode lastUnique = cur;
        while (cur != null) {
            ListNode tmp = cur.next;
            if (cur.val != lastUnique.val) {
                lastUnique.next = cur;
                lastUnique = cur;
            } else {
                lastUnique.next = null;
            }
            cur = tmp;
        }
        return head;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/discuss/28730/Concise-solution-and
     * -memory-freeing">Clean iterative solution </a>
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                //Skip duplicate
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * Recursive solution
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates3(head.next);
        if (head.val == head.next.val) {
            return head.next;
        }
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
