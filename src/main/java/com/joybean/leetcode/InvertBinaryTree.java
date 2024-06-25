package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>
 *
 * @author Joybean
 */
public class InvertBinaryTree {
    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree1(right);
        root.right = invertTree1(left);
        return root;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * Iterative solution
     * TODO
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree3(TreeNode root) {
        return null;
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
