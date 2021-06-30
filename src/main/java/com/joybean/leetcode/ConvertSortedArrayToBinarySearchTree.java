package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Convert Sorted Array to Binary
 * Search Tree</a>
 *
 * @author Joybean
 */
public class ConvertSortedArrayToBinarySearchTree {
    //TODO
    public TreeNode sortedArrayToBST(int[] nums) {
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
