package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest Common Ancestor of
 * a Binary Tree</a>
 *
 * @author Joybean
 */
public class LowestCommonAncestorOfABinaryTree {
    /**
     * Recursive solution
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftLca = lowestCommonAncestor1(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor1(root.right, p, q);
        if (leftLca != null && rightLca != null) {
            return root;
        }
        return leftLca == null ? rightLca : leftLca;
    }

    /**
     * Iterative using parent pointers
     * TODO
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
    }
}
