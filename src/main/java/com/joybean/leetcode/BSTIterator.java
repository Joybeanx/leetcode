package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 *
 * @author Joybean
 */
public class BSTIterator {
    //TODO
    public BSTIterator(TreeNode root) {

    }

    public int next() {
        return 0;
    }

    public boolean hasNext() {
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
