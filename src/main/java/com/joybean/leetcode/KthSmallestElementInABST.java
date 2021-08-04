package com.joybean.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest Element in a BST</a>
 *
 * @author Joybean
 */
public class KthSmallestElementInABST {
    private static int traversed;
    private static int ans;

    public static int kthSmallest1(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }

    /**
     * DFS
     *
     * @param root
     * @param k
     */
    private static void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, k);
        if (++traversed == k) {
            ans = root.val;
            return;
        }
        helper(root.right, k);
    }

    /**
     * Iterative solution
     *
     * @param root
     * @param k
     */
    private static int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (true) {
            pushToStack(root, stack);
            if (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                if (++count == k) {
                    return current.val;
                }
                root = current.right;
            } else {
                break;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static void pushToStack(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
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
