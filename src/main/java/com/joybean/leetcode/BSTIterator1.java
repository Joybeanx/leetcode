package com.joybean.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 *
 * @author Joybean
 */
public class BSTIterator1 {
    private Queue<Integer> queue;

    /**
     * Queue solution
     *
     * @param root
     */
    public BSTIterator1(TreeNode root) {
        queue = new LinkedList<>();
        inorderPushStack(root, queue);
    }

    private void inorderPushStack(TreeNode root, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        inorderPushStack(root.left, queue);
        queue.offer(root.val);
        inorderPushStack(root.right, queue);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
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
