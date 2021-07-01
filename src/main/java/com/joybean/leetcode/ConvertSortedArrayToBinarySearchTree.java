package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Convert Sorted Array to Binary
 * Search Tree</a>
 *
 * @author Joybean
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(0, nums.length - 1, nums);
    }

    public static TreeNode buildBST(int from, int to, int[] nums) {
        if (from > to) {
            return null;
        }
        //avoids integer overflow
        int middle = from + (to - from) / 2;
        TreeNode parent = new TreeNode(nums[middle]);
        parent.left = buildBST(from, middle - 1, nums);
        parent.right = buildBST(middle + 1, to, nums);
        return parent;
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
