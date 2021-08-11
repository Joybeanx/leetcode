package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
 *
 * @author Joybean
 */
public class MinimumDepthOfBinaryTree {
    //TODO
    public int minDepth(TreeNode root) {
        return 0;
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
