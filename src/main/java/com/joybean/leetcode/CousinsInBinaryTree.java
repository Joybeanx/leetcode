package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/cousins-in-binary-tree/">Cousins in Binary Tree</a>
 *
 * @author Joybean
 */
public class CousinsInBinaryTree {
    //TODO
    public boolean isCousins(TreeNode root, int x, int y) {
        return false;
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
