package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/next-greater-node-in-linked-list/">Next Greater Node In Linked List</a>
 *
 * @author Joybean
 */
public class NextGreaterNodeInLinkedList {
    /**
     * PriorityQueue solution
     *
     * @param head
     * @return
     */
    public static int[] nextLargerNodes1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] ans = new int[list.size()];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(i -> list.get(i)));
        cur = head;
        int idx = 0;
        while (cur != null) {
            while (!queue.isEmpty() && cur.val > list.get(queue.peek())) {
                ans[queue.poll()] = cur.val;
            }
            queue.offer(idx++);
            cur = cur.next;
        }
        return ans;
    }

    /**
     * Monotonically increasing stack
     *
     * @param head
     * @return
     * @see NextGreaterElement2#nextGreaterElements3(int[])
     */
    public static int[] nextLargerNodes2(ListNode head) {
        //Deque is much better than stack
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int curVal = list.get(i);
            while (!stack.isEmpty() && list.get(stack.peek()) < curVal) {
                ans[stack.pop()] = curVal;
            }
            stack.push(i);
        }
        return ans;
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
