package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary Tree</a>
 *
 * @author Joybean
 */
public class DiameterOfBinaryTree {
    private static int ans;

    public static int diameterOfBinaryTree1(TreeNode root) {
        longestPathNodes(root);
        return ans;
    }

    private static int longestPathNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLongestPathNodes = 1 + longestPathNodes(root.left);
        int rightLongestPathNodes = 1 + longestPathNodes(root.right);
        ans = Math.max(ans, leftLongestPathNodes + rightLongestPathNodes - 2);
        return Math.max(leftLongestPathNodes, rightLongestPathNodes);
    }

    public static int diameterOfBinaryTree2(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        ans = Math.max(ans, leftMaxDepth + rightMaxDepth);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
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
