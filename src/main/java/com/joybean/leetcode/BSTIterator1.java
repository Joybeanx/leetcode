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
        inorderStoreQueue(root, queue);
    }

    private void inorderStoreQueue(TreeNode root, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        inorderStoreQueue(root.left, queue);
        queue.offer(root.val);
        inorderStoreQueue(root.right, queue);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
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
