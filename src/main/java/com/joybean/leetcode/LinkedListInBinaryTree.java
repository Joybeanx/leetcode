package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/linked-list-in-binary-tree/"">Linked List in Binary Tree</a>
 *
 * @author Joybean
 */
public class LinkedListInBinaryTree {
    //TODO
    public boolean isSubPath(ListNode head, TreeNode root) {
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

    public static class TreeNode {
        int val;
        CountCompleteTreeNodes.TreeNode left;
        CountCompleteTreeNodes.TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, CountCompleteTreeNodes.TreeNode left, CountCompleteTreeNodes.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
