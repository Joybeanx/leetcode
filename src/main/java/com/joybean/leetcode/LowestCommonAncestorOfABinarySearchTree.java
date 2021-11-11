package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Lowest Common Ancestor of
 * a Binary Search Tree</a>
 *
 * @author Joybean
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /**
     * Recursive solution
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int rv = root.val;
        int pv = p.val;
        int qv = q.val;
        if (rv > pv && rv > qv) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (rv < pv && rv < qv) {
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * Iterative solution
     * TODO
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
    }
}
