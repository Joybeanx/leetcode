package com.joybean.leetcode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
 *
 * @author Joybean
 */
public class PathSum2 {
    //TODO
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
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
