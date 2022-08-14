package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 *
 * @author Joybean
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * Straight forward solution
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);
        if (lengthA > lengthB) {
            headA = skip(headA, lengthA - lengthB);
        } else {
            headB = skip(headB, lengthB - lengthA);
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static int length(ListNode target) {
        int length = 0;
        ListNode node = target;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public static ListNode skip(ListNode target, int n) {
        ListNode node = target;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without
     * -knowing-the-difference-in-len!">Two pointers without knowing the difference in length</a>
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            //At the end of first iteration, we just reset the pointer to the head of another linked list
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
