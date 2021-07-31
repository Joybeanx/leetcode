package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-univalue-path/">Longest Univalue Path</a>
 *
 * @author Joybean
 */
public class LongestUnivaluePath {
    //TODO
    public int longestUnivaluePath(TreeNode root) {
        return 0;
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
