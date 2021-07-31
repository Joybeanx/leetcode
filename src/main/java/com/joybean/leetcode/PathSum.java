package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/path-sum/">Path Sum</a>
 *
 * @author Joybean
 */
public class PathSum {
    //TODO
    public boolean hasPathSum(TreeNode root, int targetSum) {
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
