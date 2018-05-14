package com.joybean.oj.leetcode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">Add Two Numbers</a>
 *
 * @author Jobean
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        return add(l1, l2, false);
    }

    public static ListNode add(ListNode l1, ListNode l2, boolean carry) {
        int val1 = null != l1 ? l1.val : 0;
        int val2 = null != l2 ? l2.val : 0;
        int val = val1 + val2;
        if (carry) {
            val += 1;
            if (l1 == null && l2 == null) {
                return new ListNode(val);
            }
        }
        ListNode l = new ListNode(val);
        boolean cf;
        if (cf = val > 9) {
            l.val -= 10;
        }
        ListNode l1Next = null;
        ListNode l2Next = null;

        if (l1 == null) {
            if (!cf) {
                if (l2 != null) {
                    l.next = l2.next;
                }
                return l;
            }
        } else {
            l1Next = l1.next;
        }
        if (l2 == null) {
            if (!cf) {
                if (l1 != null) {
                    l.next = l1.next;
                }
                return l;
            }
        } else {
            l2Next = l2.next;
        }

        if (l1Next == null && l2Next == null && !cf) {
            return l;
        }
        l.next = add(l1Next, l2Next, cf);
        return l;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
