package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">Palindrome Linked List</a>
 *
 * @author Joybean
 */
public class PalindromeLinkedList {
    /**
     * Iterative solution:reversed left half == right half?
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //Slow will reach the middle and fast will reach the end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //Reverse nodes from start to middle
        ListNode leftHead = reverseLeftHalf(head, slow);
        //When linked list has odd nodes,let right half smaller so that the two halves have same length
        //for example [1,3,1], slow pointer will stop at 3
        ListNode rightHead = slow;
        if (fast != null) {
            rightHead = slow.next;
        }
        //Compare two halves
        while (rightHead != null && leftHead != null) {
            if (rightHead.val != leftHead.val) {
                return false;
            }
            rightHead = rightHead.next;
            leftHead = leftHead.next;
        }
        return true;
    }

    private static ListNode reverseLeftHalf(ListNode from, ListNode to) {
        ListNode newHead = null;
        while (from != to) {
            ListNode tmp = from.next;
            from.next = newHead;
            newHead = from;
            from = tmp;
        }
        return newHead;
    }

    /**
     * <a href="https://leetcode.com/problems/palindrome-linked-list/discuss/181453/Java-or-5-lines-method-or-2ms-or
     * -O(n)-or-recursive-or-easy-to-understand">Recursive solution</a>
     * TODO
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
