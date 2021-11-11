package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-binary-tree/">Maximum Binary Tree</a>
 *
 * @author Joybean
 */
public class MaximumBinaryTree {
    //TODO
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return null;
    }

    public static class TreeNode {
        int val;
        BinaryTreeInorderTraversal.TreeNode left;
        BinaryTreeInorderTraversal.TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, BinaryTreeInorderTraversal.TreeNode left, BinaryTreeInorderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
