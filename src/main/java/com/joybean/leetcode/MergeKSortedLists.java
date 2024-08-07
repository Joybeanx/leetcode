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

    private static void shiftDown(ListNode[] heapNodes, int heapSize) {
        int p = 0;
        int c;
        while ((c = 2 * p + 1) < heapSize) {
            //Swap with the less child
            if (c + 1 < heapSize && heapNodes[c].val > heapNodes[c + 1].val) {
                c++;
            }
            if (heapNodes[c].val < heapNodes[p].val) {
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
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return head.next;
    }

    /**
     * Divide and conquer
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeSort(0, lists.length - 1, lists);
    }

    private static ListNode mergeSort(int start, int end, ListNode[] lists) {
        //never happen
        //if (start > end) {
        //    return null;
        //}
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) >>> 1;
        ListNode leftPart = mergeSort(start, mid, lists);
        ListNode rightPart = mergeSort(mid + 1, end, lists);
        return merge1(leftPart, rightPart);
    }

    /**
     * Iterative merge
     *
     * @param leftPart
     * @param rightPart
     * @return
     * @see MergeTwoSortedLists
     */
    private static ListNode merge1(ListNode leftPart, ListNode rightPart) {
        //if (leftPart == null) {
        //    return rightPart;
        //}
        //if (rightPart == null) {
        //    return leftPart;
        //}
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (leftPart != null && rightPart != null) {
            if (leftPart.val <= rightPart.val) {
                tail.next = leftPart;
                leftPart = leftPart.next;
            } else {
                tail.next = rightPart;
                rightPart = rightPart.next;
            }
            tail = tail.next;
        }
        tail.next = leftPart != null ? leftPart : rightPart;
        return dummy.next;
    }

    /**
     * Recursive merge
     *
     * @param leftPart
     * @param rightPart
     * @return
     * @see MergeTwoSortedLists
     */
    private static ListNode merge2(ListNode leftPart, ListNode rightPart) {
        if (leftPart == null) {
            return rightPart;
        }
        if (rightPart == null) {
            return leftPart;
        }
        if (leftPart.val <= rightPart.val) {
            leftPart.next = merge2(leftPart.next, rightPart);
            return leftPart;
        }
        rightPart.next = merge2(leftPart, rightPart.next);
        return rightPart;
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
    }
}
