package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/sort-list/">Sort List</a>
 *
 * @author Joybean
 */
public class SortList {
    /**
     * Insertion sort:Time Limit Exceeded
     *
     * @param head
     * @return
     * @see InsertionSortList#insertionSortList2(com.joybean.leetcode.InsertionSortList.ListNode)
     */
    public static ListNode sortList1(ListNode head) {
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
     * <a href="https://leetcode.com/problems/sort-list/solution/">Merge sort</a>
     *
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
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
