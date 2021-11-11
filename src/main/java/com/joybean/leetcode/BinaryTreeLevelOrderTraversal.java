package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
 *
 * @author Joybean
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * BFS
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelNodes.add(current.val);
                Stream.of(current.left, current.right).filter(Objects::nonNull).forEach(queue::add);
            }
            ans.add(levelNodes);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/114449/A-general-approach-to
     * -level-order-traversal-questions-in-Java">DFS</a>
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private static void helper(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        helper(root.left, level + 1, ans);
        helper(root.right, level + 1, ans);
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
