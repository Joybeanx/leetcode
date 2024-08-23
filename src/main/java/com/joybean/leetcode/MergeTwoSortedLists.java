package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a>
 *
 * @author Joybean
 */
public class MergeTwoSortedLists {
    /**
     * Iterative solution using two pointers
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = dummy;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 != null ? cur1 : cur2;
        return dummy.next;
    }

    /**
     * <a href="https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using
     * -recursion">Recursive solution</a>
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists2(l1, l2.next);
        return l2;
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
