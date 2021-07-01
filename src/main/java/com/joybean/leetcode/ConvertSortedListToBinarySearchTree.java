package com.joybean.leetcode;

import com.joybean.leetcode.ConvertSortedListToBinarySearchTree.ListNode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">Convert Sorted List to Binary
 * Search Tree</a>
 *
 * @author Joybean
 */
public class ConvertSortedListToBinarySearchTree {
    private static ListNode listNode;

    /**
     * Divide and conquer, time complexity O(nlogn)
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST1(ListNode head) {
        return buildTree(head, null);
    }

    public static TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public static ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Inorder traversal
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST2(ListNode head) {
        listNode = head;
        ListNode runner = head;
        int size = 0;
        while (runner != null) {
            runner = runner.next;
            size++;
        }
        return inorderHelper(1, size);
    }

    private static TreeNode inorderHelper(int from, int to) {
        if (from > to) {
            return null;
        }
        int middle = from + (to - from) / 2;
        TreeNode leftTree = inorderHelper(from, middle - 1);
        TreeNode parent = new TreeNode(listNode.val);
        parent.left = leftTree;
        //ListNode is the result of inorder traversal
        listNode = listNode.next;
        TreeNode rightTree = inorderHelper(middle + 1, to);
        parent.right = rightTree;
        return parent;

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

        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {}

            TreeNode(int val) { this.val = val; }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }
}
