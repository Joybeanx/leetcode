package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/odd-even-linked-list/">Odd Even Linked List</a>
 *
 * @author Joybean
 */
public class OddEvenLinkedList {

    /**
     * One pointer
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList1(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evenTail = evenHead;
        ListNode current = head;
        boolean odd = true;
        while (current != null) {
            ListNode tail = odd ? oddTail : evenTail;
            ListNode next = current.next;
            current.next = tail.next;
            tail.next = current;
            if (odd) {
                oddTail = tail.next;
            } else {
                evenTail = tail.next;
            }
            current = next;
            odd = !odd;
        }
        evenTail.next = null;
        oddTail.next = evenHead.next;
        return oddHead.next;
    }

    /**
     * <a href="https://leetcode.com/problems/odd-even-linked-list/solutions/78079/simple-o-n-time-o-1-space-java
     * -solution/">Two pointers</a>
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
