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
     * Divide and conquer<br/>
     * Time complexity: O(N log k), where N is the total number of nodes in all the linked lists,
     * and k is the number of linked lists
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists3(ListNode[] lists) {
        return mergeSort(0, lists.length - 1, lists);
    }

    private static ListNode mergeSort(int start, int end, ListNode[] lists) {
        //only if lists.length is 0
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) >>> 1;
        ListNode l1 = mergeSort(start, mid, lists);
        ListNode l2 = mergeSort(mid + 1, end, lists);
        return merge1(l1, l2);
    }

    /**
     * Iterative merge 1
     *
     * @param l1
     * @param l2
     * @return
     * @see MergeTwoSortedLists
     */
    private static ListNode merge1(ListNode l1, ListNode l2) {
        //if (leftPart == null) {
        //    return rightPart;
        //}
        //if (rightPart == null) {
        //    return leftPart;
        //}
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    private static ListNode merge2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                cur.next = l1;
                l1 = l1.next;
            } else if (val1 > val2) {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * Recursive merge
     *
     * @param l1
     * @param l2
     * @return
     * @see MergeTwoSortedLists
     */
    private static ListNode merge3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge3(l1.next, l2);
            return l1;
        }
        l2.next = merge3(l1, l2.next);
        return l2;
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


    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSortx(0, lists.length - 1, lists);
    }

    private ListNode mergeSortx(int start, int end, ListNode[] lists) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int pivot = (start + end) >>> 1;
        ListNode l1 = mergeSortx(start, pivot, lists);
        ListNode l2 = mergeSortx(pivot + 1, end, lists);
        return mergex(l1, l2);
    }

    private ListNode mergex(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                cur.next = l1;
                l1 = l1.next;
            } else if (val1 > val2) {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
