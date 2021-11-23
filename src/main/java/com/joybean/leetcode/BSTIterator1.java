package com.joybean.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 *
 * @author Joybean
 */
public class BSTIterator1 {
    private Queue<Integer> queue;

    private Stack<TreeNode> stack;

    public BSTIterator1(TreeNode root) {
        queue = new LinkedList<>();
        inorderStoreQueue(root, queue);

        stack = new Stack<>();
        putLeftMostToStack(root);
    }

    private void putLeftMostToStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private void inorderStoreQueue(TreeNode root, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        inorderStoreQueue(root.left, queue);
        queue.offer(root.val);
        inorderStoreQueue(root.right, queue);
    }

    /**
     * Queue solution
     *
     * @return
     */
    public int next1() {
        return queue.poll();
    }

    public boolean hasNext1() {
        return !queue.isEmpty();
    }

    /**
     * Stack solution
     *
     * @return
     */
    public int next2() {
        int next = stack.peek().val;
        putLeftMostToStack(stack.pop().right);
        return next;
    }

    public boolean hasNext2() {
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
