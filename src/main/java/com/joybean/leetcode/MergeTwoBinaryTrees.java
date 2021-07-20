package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/merge-two-binary-trees/">Diameter of Binary Tree</a>
 *
 * @author Joybean
 */
public class MergeTwoBinaryTrees {
    //TODO
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return null;
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
