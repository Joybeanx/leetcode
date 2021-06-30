package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/">Find Mode in Binary Search Tree</a>
 *
 * @author Joybean
 */
public class FindModeInBinarySearchTree {
    //TODO
    public int[] findMode(TreeNode root) {
        return null;
    }

    public class TreeNode {
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
