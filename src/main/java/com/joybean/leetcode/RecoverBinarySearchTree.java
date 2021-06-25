package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/recover-binary-search-tree/">Recover Binary Search Tree</a>
 *
 * @author Joybean
 */
public class RecoverBinarySearchTree {
    /**
     * TODO
     * @param root
     */
    public void recoverTree(TreeNode root) {

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
