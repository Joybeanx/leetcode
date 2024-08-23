package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
 *
 * @author Joybean
 */
public class ReorderList {
    /**
     * HashMap solution
     *
     * @param head
     */
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
     * <a href="https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps">Better HashMap
     * solution,from davidluoyes</a>
     *
     * @param head
     */
    public static void reorderList2(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        for (int i = 1; head != null; head = head.next, i++) {
            map.put(i, head);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        //1,2,3,4
        for (int i = 1, j = map.size(); i <= j; i++, j--) {
            //curr->1
            curr.next = map.get(i);
            if (i != j) {
                //1->4
                map.get(i).next = map.get(j);
            }
            //4->null
            map.get(j).next = null;
            //curr = 4
            curr = map.get(j);
        }
    }

    /**
     * Find middle + Reverse right half + Merge
     *
     * @param head
     */
    public static void reorderList3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //1:Find the first middle node
        //for 1->2->3->4, middle is 2
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //2:Reverse list from the second middle node
        //1->2->3<-4
        ListNode cur = slow.next;

        ListNode reversedHead = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = reversedHead;
            reversedHead = cur;
            cur = tmp;
        }

        //3:cut the list into two halves from the first middle node
        //1->2 4->3
        slow.next = null;

        ListNode cur1 = head;
        ListNode cur2 = reversedHead;
        //4:Merge two halves
        while (cur1 != null && cur2 != null) {
            ListNode next1 = cur1.next;
            ListNode next2 = cur2.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur1 = next1;
            cur2 = next2;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps">Find middle +
     * Reverse range + Merge </a>
     *
     * @param head
     */
    public static void reorderList4(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //1:Find the second middle node
        //for 1->2->3->4, middle is 3
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;
        //2:Reverse list from the middle node
        //1->2->3<-4
        ListNode reversedHead = null;
        ListNode cur1 = middle;
        while (cur1 != null) {
            ListNode tmp = cur1.next;
            cur1.next = reversedHead;
            reversedHead = cur1;
            cur1 = tmp;
        }
        //3:Merge two halves
        cur1 = head;
        ListNode cur2 = reversedHead;
        //[head,middle) of the second half
        //using cur1 != middle would cause a circle, 1->4->2->3->3
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
