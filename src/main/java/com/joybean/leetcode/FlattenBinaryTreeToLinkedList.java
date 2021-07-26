package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
 *
 * @author Joybean
 */
public class FlattenBinaryTreeToLinkedList {
    private static TreeNode prev = null;

    public static void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten1(left);
        flatten1(right);
        root.right = left;
        TreeNode flattenedTail = root;
        while (flattenedTail.right != null) {
            flattenedTail = flattenedTail.right;
        }
        flattenedTail.right = right;
        root.left = null;
    }

    /**
     * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal
     * -Java-solution-for-share
     *
     * @param root
     */
    public static void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten2(root.right);
        flatten2(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
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
