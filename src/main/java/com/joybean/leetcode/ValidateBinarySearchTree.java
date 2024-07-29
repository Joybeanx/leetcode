package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 *
 * @author Joybean
 */
public class ValidateBinarySearchTree {

     /*
     //wrong solution
     public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
    */

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        //Use Long instead of Integer, failed case:[-2147483648,-2147483648]
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST1(TreeNode curNode, long min, long max) {
        if (curNode == null) {
            return true;
        }
        if (curNode.val < min || curNode.val > max) {
            return false;

        }
        return isValidBST1(curNode.left, min, curNode.val - 1) && isValidBST1(curNode.right, curNode.val + 1, max);
    }

    /**
     * Optimized DFS
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        //Use Long instead of Integer, failed case:[-2147483648,-2147483648]
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST2(TreeNode curNode, long min, long max) {
        if (curNode == null) {
            return true;
        }
        if (curNode.val <= min || curNode.val >= max) {
            return false;

        }
        return isValidBST2(curNode.left, min, curNode.val) && isValidBST2(curNode.right, curNode.val, max);
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static boolean isValidBST3(TreeNode root) {
        return isValidBST3(root, null, null);
    }

    public static boolean isValidBST3(TreeNode curNode, Integer max, Integer min) {
        if (curNode == null) {
            return true;
        }
        if (max != null && curNode.val >= max || min != null && curNode.val <= min) {
            return false;
        }
        return isValidBST3(curNode.left, curNode.val, min) && isValidBST3(curNode.right, max, curNode.val);
    }

    /**
     * <a href="https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution/">Inorder traversal using stack</a>
     * TODO
     *
     * @param root
     * @return
     */
    public boolean isValidBST4(TreeNode root) {
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
