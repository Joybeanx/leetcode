package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/">Construct Binary Search
 * Tree from Preorder Traversal</a>
 *
 * @author Joybean
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    //TODO
    public TreeNode bstFromPreorder(int[] preorder) {
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
