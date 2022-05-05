package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">Remove Duplicates from Sorted List
 * II</a>
 *
 * @author Joybean
 */
public class RemoveDuplicatesFromSortedList2 {
    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/">Iterative solution</a>
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode cur = head;
        //the last node before the sublist of duplicates
        ListNode pred = sentinel;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                // move till the end of duplicates sublist
                do {
                    cur = cur.next;
                } while (cur.next != null && cur.val == cur.next.val);
                // skip all duplicates, but shouldn't move predecessor
                pred.next = cur.next;
            } else {
                //move predecessor
                pred = pred.next;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code">Iterative
     * solution 2</a>
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode cur = head;
        //the last node before the sublist of duplicates
        ListNode pred = sentinel;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                // move till the end of duplicates sublist
                cur = cur.next;
            }
            //cur.val is distinct
            if (pred.next == cur) {
                //move predecessor
                pred = pred.next;
            } else {
                //skip all duplicates, but shouldn't move predecessor
                pred.next = cur.next;
            }
            cur = cur.next;
        }
        return sentinel.next;
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
        if (head.val != head.next.val) {
            head.next = deleteDuplicates3(head.next);
            return head;
        }
        do {
            head = head.next;
        } while (head.next != null && head.val == head.next.val);
        return deleteDuplicates3(head.next);
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
