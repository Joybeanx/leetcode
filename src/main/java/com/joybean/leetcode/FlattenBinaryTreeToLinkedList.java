package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
 *
 * @author Joybean
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * Postorder traversal
     * @param root
     */
    public static void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten1(left);
        flatten1(right);
        if (left != null) {
            TreeNode tailOfFlattenedLeft = left;
            while (tailOfFlattenedLeft.right != null) {
                tailOfFlattenedLeft = tailOfFlattenedLeft.right;
            }
            tailOfFlattenedLeft.right = right;
            root.right = left;
        } else {
            root.right = right;
        }
        root.left = null;
    }

    /**
     * Postorder traversal
     * @param root
     */
    public static void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten2(left);
        flatten2(right);
        root.right = left;
        TreeNode flattenedTail = root;
        while (flattenedTail.right != null) {
            flattenedTail = flattenedTail.right;
        }
        flattenedTail.right = right;
        root.left = null;
    }

    private static TreeNode prev = null;

    /**
     * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal
     * -Java-solution-for-share">Reversed postorder traversal</a>
     *
     * @param root
     */
    public static void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten3(root.right);
        flatten3(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode pre;

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

}
