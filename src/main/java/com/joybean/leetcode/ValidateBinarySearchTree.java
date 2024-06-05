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
     * Recursive solution
     *
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, null, null);
    }

    public static boolean isValidBST1(TreeNode curNode, Integer max, Integer min) {
        if (curNode == null) {
            return true;
        }
        if (max != null && curNode.val >= max || min != null && curNode.val <= min) {
            return false;
        }
        return isValidBST1(curNode.left, curNode.val, min) && isValidBST1(curNode.right, max, curNode.val);
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
