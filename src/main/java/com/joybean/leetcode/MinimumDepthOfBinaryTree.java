package com.joybean.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
 *
 * @author Joybean
 */
public class MinimumDepthOfBinaryTree {
    private static int ans;

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = Integer.MAX_VALUE;
        helper(root, 1);
        return ans;
    }

    private static void helper(TreeNode node, int level) {
        if (node == null || level >= ans) {
            return;
        }
        if (node.left == null && node.right == null) {
            ans = level;
            return;
        }
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }

    /**
     * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution">More
     * concise but slower DFS</a>
     *
     * @param root
     * @return
     */
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMinDepth = minDepth2(root.left);
        int rightMinDepth = minDepth2(root.right);
        if (leftMinDepth == 0 || rightMinDepth == 0) {
            return leftMinDepth + rightMinDepth + 1;
        }
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public static int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
