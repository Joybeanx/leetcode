package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/">Symmetric Tree</a>
 *
 * @author Joybean
 */
public class SymmetricTree {
    //TODO
    public boolean isSymmetric(TreeNode root) {
        return false;
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
