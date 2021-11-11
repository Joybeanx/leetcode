package com.joybean.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 *
 * @author Joybean
 */
public class BSTIterator2 {
    private Stack<TreeNode> stack;

    /**
     * Stack solution
     *
     * @param root
     */
    public BSTIterator2(TreeNode root) {
        stack = new Stack<>();
        putLeftMostToStack(root);
    }

    private void putLeftMostToStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        int next = stack.peek().val;
        putLeftMostToStack(stack.pop().right);
        return next;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
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
