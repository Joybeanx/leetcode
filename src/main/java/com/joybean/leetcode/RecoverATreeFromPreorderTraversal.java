package com.joybean.leetcode;

/**
 *
 * <a href="https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/">Recover a Tree From Preorder Traversal</a>
 *
 * @author Joybean
 */
public class RecoverATreeFromPreorderTraversal {
    //TODO
    public TreeNode recoverFromPreorder(String traversal) {
        return null;
    }

    public class TreeNode {
        int val;
        BinaryTreeInorderTraversal.TreeNode left;
        BinaryTreeInorderTraversal.TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, BinaryTreeInorderTraversal.TreeNode left, BinaryTreeInorderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
