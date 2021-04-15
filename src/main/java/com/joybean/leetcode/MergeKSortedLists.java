package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 *
 * @author Joybean
 */
public class MergeKSortedLists {
    /**
     * Min Heap
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        ListNode mergedListNode = null;
        ListNode tail = null;
        ListNode[] heapNodes = Arrays.stream(lists).filter(Objects::nonNull).toArray(ListNode[]::new);
        int heapSize = heapNodes.length;
        for (int i = 1; i < heapNodes.length; i++) {
            shiftUp(i, heapNodes);
        }
        while (heapSize > 0) {
            if (tail == null) {
                mergedListNode = tail = heapNodes[0];
            } else {
                tail.next = heapNodes[0];
                tail = tail.next;
            }
            if (heapNodes[0] != null && heapNodes[0].next != null) {
                heapNodes[0] = heapNodes[0].next;
            } else {
                swap(0, heapSize - 1, heapNodes);
                heapSize--;
            }
            shiftDown(heapNodes, heapSize);
        }
        return mergedListNode;
    }

    /**
     * Priority Queue
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparing(ln -> ln.val));
        for (ListNode ln : lists) {
            if (ln != null) {
                queue.offer(ln);
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        return head.next;
    }

    private static void shiftDown(ListNode[] heapNodes, int heapSize) {
        int p = 0;
        int c;
        while ((c = 2 * p + 1) < heapSize) {
            //Swap with the less child
            if (c + 1 < heapSize && heapNodes[c].val > heapNodes[c + 1].val) {
                c++;
            }
            if (heapNodes[c].val <= heapNodes[p].val) {
                swap(c, p, heapNodes);
                p = c;
                continue;
            }
            break;
        }
    }

    private static void shiftUp(int i, ListNode[] lists) {
        int p = i;
        while (p != 0) {
            p = (i - 1) / 2;
            if (lists[p].val > lists[i].val) {
                swap(p, i, lists);
                i = p;
                continue;
            }
            break;
        }
    }

    private static void swap(int a, int b, ListNode[] lists) {
        ListNode temp = lists[a];
        lists[a] = lists[b];
        lists[b] = temp;
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

        ListNode(int[] nums) {
            ListNode prev = null;
            ListNode current = null;
            for (int i = nums.length - 1; i >= 0; i--) {
                current = new ListNode(nums[i]);
                if (prev != null) {
                    current.next = prev;
                }
                prev = current;
            }
            this.val = current.val;
            this.next = current.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[] {1, 3, 5, 7, 9, 11});
        ListNode l2 = new ListNode(new int[] {2, 4, 6, 8, 10, 12});
        ListNode l3 = new ListNode(new int[] {1, 8, 13, 16, 20, 28, 31});
        ListNode l4 = new ListNode(new int[] {11, 18, 23, 26, 30, 38, 41});
        ListNode l5 = new ListNode(new int[] {7, 15, 21, 31, 33, 41, 43});
        ListNode r = mergeKLists2(new ListNode[] {l1, l2, l3, l4, l5});
        System.out.println(r);
    }
}
