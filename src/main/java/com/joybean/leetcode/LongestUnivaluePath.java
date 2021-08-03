package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-univalue-path/">Longest Univalue Path</a>
 *
 * @author Joybean
 */
public class LongestUnivaluePath {
    private static int ans;

    public static int longestUnivaluePath1(TreeNode root) {
        maxUnivalueHeightFrom(root, null);
        return ans;
    }

    private static int maxUnivalueHeightFrom(TreeNode node, TreeNode parent) {
        if (node == null) {
            return 0;
        }
        int length = 0;
        if (parent != null && node.val == parent.val) {
            length++;
        }
        int leftLongestPath = maxUnivalueHeightFrom(node.left, node);
        int rightLongestPath = maxUnivalueHeightFrom(node.right, node);
        ans = Math.max(ans, leftLongestPath + rightLongestPath);
        if (length > 0) {
            length += Math.max(leftLongestPath, rightLongestPath);
        }
        return length;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-univalue-path/solution/">Recursion</a>
     *
     * @param root
     * @return
     */
    public static int longestUnivaluePath2(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public static int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
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
