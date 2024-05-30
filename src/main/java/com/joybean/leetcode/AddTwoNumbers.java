package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">Add Two Numbers</a>
 *
 * @author Joybean
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
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(val);
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(val);
            l2 = l2.next;
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    /**
     * Concise solution
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = carry + val1 + val2;
            carry = sum / 10;
            int val = sum % 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
