package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii/"> Path Sum III</a>
 *
 * @author Joybean
 */
public class PathSum3 {
    //TODO
    public int pathSum(TreeNode root, int targetSum) {
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
