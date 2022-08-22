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
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode node = dummy;
            while (node.next != null && cur.val > node.next.val) {
                node = node.next;
            }
            cur.next = node.next;
            node.next = cur;
            cur = next;
        }
        return dummy.next;
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
