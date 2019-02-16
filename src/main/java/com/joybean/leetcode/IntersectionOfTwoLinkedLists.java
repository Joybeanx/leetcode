package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 *
 * @author Joybean
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public int length(ListNode target) {
        int length = 0;
        ListNode node = target;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public ListNode skip(ListNode target, int n) {
        ListNode node = target;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        return node;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
