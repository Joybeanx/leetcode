package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/insertion-sort-list/">Insertion Sort List</a>
 *
 * @author Joybean
 */
public class InsertionSortList {
    /**
     * Recursive solution
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList1(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode sortedTail = dummy;
        insertionSortListInternal(dummy, head, sortedTail);
        return dummy.next;
    }

    private static void insertionSortListInternal(ListNode sortedHead, ListNode target, ListNode sortedTail) {
        if (target == null) {
            return;
        }
        ListNode nextTarget = target.next;
        ListNode cur = sortedHead;
        ListNode prev = null;
        while (cur != null && cur != target) {
            if (target.val <= cur.val) {
                sortedTail.next = target.next;
                prev.next = target;
                target.next = cur;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        if (cur == target) {
            sortedTail = cur;
        }
        insertionSortListInternal(sortedHead, nextTarget, sortedTail);
    }

    /**
     * <a href="https://leetcode.com/problems/insertion-sort-list/discuss/46420/An-easy-and-clear-way-to-sort-(-O(1)
     * -space-)">Iterative solution</a>
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList2(ListNode head) {
        //must not specify next
        ListNode sortedNode = new ListNode(0);
        ListNode target = head;
        while (target != null) {
            ListNode nextTarget = target.next;
            ListNode prev = sortedNode;
            while (prev.next != null && target.val > prev.next.val) {
                prev = prev.next;
            }
            target.next = prev.next;
            prev.next = target;
            target = nextTarget;
        }
        return sortedNode.next;
    }

    /**
     * <a href="https://leetcode.com/problems/insertion-sort-list/discuss/46420/An-easy-and-clear-way-to-sort-(-O(1)
     * -space-)">Optimized iterative solution (by Xing_)</a>
     * TODO
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList3(ListNode head) {
        return null;
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
