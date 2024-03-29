package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 *
 * @author Joybean
 */
public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
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
