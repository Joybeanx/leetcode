package com.joybean.leetcode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
 *
 * @author Joybean
 */
public class BinaryTreeLevelOrderTraversal {
    //TODO
    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    public class TreeNode {
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
