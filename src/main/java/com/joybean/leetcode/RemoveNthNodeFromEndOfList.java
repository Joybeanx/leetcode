package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Remove Nth Node From End of List</a>
 *
 * @author Joybean
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Fast and Slow Pointer
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode slow = head;
        ListNode prev = dummy;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return dummy.next;
    }


    /**
     * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/8804/Simple-Java-solution-in
     * -one-pass">Cleaner two pointers solution</a>
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        //Move fast in front so that the gap between slow and fast becomes n+1
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return dummy.next;
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
