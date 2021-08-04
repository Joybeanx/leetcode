package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Binary Tree Preorder Traversal</a>
 *
 * @author Joybean
 */
public class BinaryTreePreorderTraversal {
    /**
     * Recursive Approach
     *
     * @param root
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private static void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }

    /**
     * Iterating method
     *
     * @param root
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return res;
    }

    /**
     * Iterating method:only right children are stored to stack
     *
     * @param root
     */
    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> rights = new Stack<>();
        while (root != null) {
            res.add(root.val);
            if (root.right != null) {
                rights.push(root.right);
            }
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pop();
            }
        }
        return res;
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
