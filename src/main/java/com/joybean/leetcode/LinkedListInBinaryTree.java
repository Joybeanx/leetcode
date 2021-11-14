package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/linked-list-in-binary-tree/"">Linked List in Binary Tree</a>
 *
 * @author Joybean
 */
public class LinkedListInBinaryTree {
    /**
     * DFS
     *
     * @param head
     * @param root
     * @return
     */
    public static boolean isSubPath1(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isConsecutivePath(head, root) || isSubPath1(head, root.left)
            || isSubPath1(head, root.right);
    }

    private static boolean isConsecutivePath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return head.val == root.val && (isConsecutivePath(head.next, root.left) || isConsecutivePath(head.next, root.right));
    }

    /**
     * DP
     * TODO
     *
     * @param head
     * @param root
     * @return
     */
    public static boolean isSubPath2(ListNode head, TreeNode root) {
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
