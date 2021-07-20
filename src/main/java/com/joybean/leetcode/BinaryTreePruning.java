package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-pruning/">Binary Tree Pruning</a>
 *
 * @author Joybean
 */
public class BinaryTreePruning {
    //TODO
    public TreeNode pruneTree(TreeNode root) {
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
