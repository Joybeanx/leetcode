package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">Two Sum IV - Input is a BST</a>
 *
 * @author Joybean
 */
public class TwoSumIV {
    //TODO
    public boolean findTarget(TreeNode root, int k) {
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left,
            TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
