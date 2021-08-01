package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/path-sum/">Path Sum</a>
 *
 * @author Joybean
 */
public class PathSum {
    /**
     * DFS
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumInternal(root, 0, targetSum);
    }

    private static boolean hasPathSumInternal(TreeNode root, int curSum, int targetSum) {
        if (root == null) {
            return false;
        }
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == targetSum) {
                return true;
            }
        }
        return hasPathSumInternal(root.left, curSum, targetSum) || hasPathSumInternal(root.right, curSum, targetSum);
    }

    /**
     * More concise DFS solution
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int nextTargetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return nextTargetSum == 0;
        }
        return hasPathSum2(root.left, nextTargetSum) || hasPathSum2(root.right, nextTargetSum);
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
