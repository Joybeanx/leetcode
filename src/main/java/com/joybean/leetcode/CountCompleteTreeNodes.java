package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes/">Count Complete Tree Nodes</a>
 *
 * @author Joybean
 */
public class CountCompleteTreeNodes {
    //TODO
    public int countNodes(TreeNode root) {
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
