package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/cousins-in-binary-tree/">Cousins in Binary Tree</a>
 *
 * @author Joybean
 */
public class CousinsInBinaryTree {
    private static TreeNode xParent;
    private static TreeNode yParent;
    private static int xLevel;
    private static int yLevel;

    /**
     * DFS
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public static boolean isCousins1(TreeNode root, int x, int y) {
        helper(null, root, 0, x, y);
        if (xParent != null && yParent != null) {
            return xParent != yParent && xLevel == yLevel;
        }
        return false;
    }

    public static void helper(TreeNode parent, TreeNode node, int level, int x, int y) {
        if (node == null) {
            return;
        }
        if (x == node.val) {
            xParent = parent;
            xLevel = level;
        } else if (y == node.val) {
            yParent = parent;
            yLevel = level;
        }
        helper(node, node.left, level + 1, x, y);
        helper(node, node.right, level + 1, x, y);
    }

    /**
     * BFS
     * TODO
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public static boolean isCousins2(TreeNode root, int x, int y) {
        return false;
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
