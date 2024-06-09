package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">Remove Duplicates from Sorted List II</a>
 *
 * @author Joybean
 */
public class RemoveDuplicatesFromSortedList2 {
    /**
     * Iterative solution
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(101, null);
        ListNode prev = dummy;
        ListNode tail = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val || cur.val == prev.val) {
                prev = cur;
                cur = cur.next;
                if (cur == null) {
                    return dummy.next;
                }
            }
            tail.next = cur;
            prev = cur;
            cur = cur.next;
            tail = tail.next;
            tail.next = null;
        }
        return dummy.next;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/">Iterative solution</a>
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        //the last node before the sublist of duplicates
        ListNode pred = dummy;
        while (cur != null) {
            //duplicates exists from current node
            if (cur.next != null && cur.val == cur.next.val) {
                // move till the end of duplicates sublist
                do {
                    cur = cur.next;
                } while (cur.next != null && cur.val == cur.next.val);
                // skip all duplicates, but shouldn't move predecessor
                pred.next = cur.next;
            } else {
                //move predecessor
                //or: pred = cur
                pred = pred.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code">Iterative
     * solution 2</a>
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates3(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        //the last node before the sublist of duplicates
        ListNode pred = dummy;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                // move till the end of duplicates sublist
                cur = cur.next;
            }
            //cur.val is distinct
            if (pred.next == cur) {
                //move predecessor
                //or: pred = cur
                pred = pred.next;
            } else {
                //skip all duplicates, but shouldn't move predecessor
                pred.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * Recursive solution
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates4(head.next);
            return head;
        }
        do {
            head = head.next;
        } while (head.next != null && head.val == head.next.val);
        return deleteDuplicates4(head.next);
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
