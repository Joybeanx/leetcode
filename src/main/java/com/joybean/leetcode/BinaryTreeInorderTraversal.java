package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">Binary Tree Inorder Traversal</a>
 *
 * @author Joybean
 */
public class BinaryTreeInorderTraversal {
    /**
     * Recursive Approach
     *
     * @param root
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private static void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }

    /**
     * Iterating method using Stack
     *
     * @param root
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * Morris Traversal
     * TODO
     *
     * @param root
     */
    public static List<Integer> inorderTraversal3(TreeNode root) {
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
