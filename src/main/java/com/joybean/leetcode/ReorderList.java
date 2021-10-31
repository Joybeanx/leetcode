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
