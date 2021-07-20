package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>
 *
 * @author Joybean
 */
public class InvertBinaryTree {
    //TODO
    public TreeNode invertTree(TreeNode root) {
        return null;
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
