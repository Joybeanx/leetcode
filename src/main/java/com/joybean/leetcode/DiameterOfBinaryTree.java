package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary Tree</a>
 *
 * @author Joybean
 */
public class DiameterOfBinaryTree {
    private static int ans;

    /**
     * DFS: longest path nodes
     *
     * @param root
     * @return
     */
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

    /**
     * <a href="https://leetcode.com/problems/diameter-of-binary-tree/discuss/101132/Java-Solution-MaxDepth">DFS: max
     * depth</a>
     *
     * @param root
     * @return
     */
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

    /**
     * DFS: single side diameter
     *
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree3(TreeNode root) {
        singleSideDiameter(root);
        return ans;
    }

    public static int singleSideDiameter(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftDiameter = singleSideDiameter(root.left);
        int rightDiameter = singleSideDiameter(root.right);
        ans = Math.max(leftDiameter + rightDiameter + 2, ans);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
