package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of Binary Tree</a>
 *
 * @author Joybean
 */
public class MaximumDepthOfBinaryTree {
    /**
     * DFS
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth1(root.left);
        int rightMaxDepth = maxDepth1(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
