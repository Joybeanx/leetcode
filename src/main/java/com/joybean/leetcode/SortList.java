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
        ListNode dummy = new ListNode(0);
        ListNode target = head;
        while (target != null) {
            ListNode nextTarget = target.next;
            ListNode prev = dummy;
            while (prev.next != null && target.val > prev.next.val) {
                prev = prev.next;
            }
            target.next = prev.next;
            prev.next = target;
            target = nextTarget;
        }
        return dummy.next;
    }

    /**
     * Insertion sort 2:Time Limit Exceeded
     *
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, null);
        ListNode cur1 = head;
        while (cur1 != null) {
            ListNode cur2 = dummy;
            ListNode prev = null;
            while (cur2 != null && cur1.val > cur2.val) {
                prev = cur2;
                cur2 = cur2.next;
            }
            ListNode next = cur1.next;
            cur1.next = prev.next;
            prev.next = cur1;
            cur1 = next;
        }
        return dummy.next;
    }

    /**
     * <a href="https://leetcode.com/problems/sort-list/solutions/46714/java-merge-sort-solution/">Merge sort</a>
     *
     * @param head
     * @return
     */
    public static ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode leftPart = sortList3(head);
        ListNode rightPart = sortList3(slow);
        return merge(leftPart, rightPart);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return dummy.next;
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
