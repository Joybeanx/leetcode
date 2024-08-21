package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest Common Ancestor of
 * a Binary Tree</a>
 *
 * @author Joybean
 */
public class LowestCommonAncestorOfABinaryTree {
    /**
     * DFS
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
        TreeNode ancestor = lowestCommonAncestor1(root.left, p, q);
        if (ancestor != null) {
            return ancestor;
        }
        ancestor = lowestCommonAncestor1(root.right, p, q);
        if (ancestor != null) {
            return ancestor;
        }
        if (contains(root.left, p) && contains(root.right, q) || contains(root.left, q) && contains(root.right, p)) {
            return root;
        }
        return null;
    }

    private static boolean contains(TreeNode node, TreeNode p) {
        if (node == null) {
            return false;
        }
        if (node == p) {
            return true;
        }
        return contains(node.left, p) || contains(node.right, p);
    }

    /**
     * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solutions/65226/my-java
     * -solution-which-is-easy-to-understand/">Optimized DFS solution</a>
     * <ul>
     *  <li>if both p and q exist in Tree rooted at root, then return their LCA</li>
     *  <li>if neither p and q exist in Tree rooted at root, then return null</li>
     *  <li>if only one of p or q (NOT both of them), exists in Tree rooted at root, return it</li>
     * </ul>
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //Found target
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftLca = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor2(root.right, p, q);
        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }
        //Root is the lca when targets were found both in the left tree and right tree
        return root;
    }

    /**
     * Iterative using parent pointers
     * TODO
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
