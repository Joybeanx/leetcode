package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
 *
 * @author Joybean
 */
public class ReorderList {
    public static void reorderList1(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int index = 0;
        while (node != null) {
            map.put(++index, node);
            node = node.next;
        }
        int size = map.size();
        int middleIdx = (size + 1) / 2;
        ListNode middle = map.get(middleIdx);
        ListNode cur = middle.next;
        int curIdx = middleIdx + 1;
        middle.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            ListNode prev = map.get(size - (curIdx++) + 1);
            ListNode next = prev.next;
            prev.next = cur;
            cur.next = next;
            cur = tmp;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps">Find middle +
     * Reverse range + Merge </a>
     *
     * @param head
     * @see <a href="https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps"></a>
     */
    public static void reorderList2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //1:Find the second middle node
        //1->2->3->4
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;
        //2:Reverse list from the middle node
        //1->2->3<-4
        ListNode next = null;
        ListNode cur1 = middle;
        while (cur1 != null) {
            ListNode tmp = cur1.next;
            cur1.next = next;
            next = cur1;
            cur1 = tmp;
        }
        //3:Merge two halves
        cur1 = head;
        ListNode cur2 = next;
        //[head,middle) of the second half
        while (cur2 != middle) {
            ListNode tmp1 = cur1.next;
            ListNode tmp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = tmp1;
            cur1 = tmp1;
            cur2 = tmp2;
        }
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
