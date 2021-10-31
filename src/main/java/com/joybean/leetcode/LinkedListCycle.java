package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">Linked List Cycle</a>
 *
 * @author Joybean
 */
public class LinkedListCycle {
    /**
     * Two pointer solution
     *
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
            if (fast != null && fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/linked-list-cycle/discuss/44694/Accepted-clean-Java-solution>Clean two
     * pointer solution</a>
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}
