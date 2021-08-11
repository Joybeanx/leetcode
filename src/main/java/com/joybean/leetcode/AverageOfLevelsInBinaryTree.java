package com.joybean.leetcode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">Average of Levels in Binary Tree</a>
 *
 * @author Joybean
 */
public class AverageOfLevelsInBinaryTree {
    //TODO
    public List<Double> averageOfLevels(TreeNode root) {
        return null;
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
