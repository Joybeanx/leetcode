package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">Binary Tree Level Order Traversal
 * II</a>
 *
 * @author Joybean
 */
public class BinaryTreeLevelOrderTraversal2 {
    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper1(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }

    private static void helper1(TreeNode root, int level, List<List<Integer>> topDownLevels) {
        if (root == null) {
            return;
        }
        if (topDownLevels.size() == level) {
            topDownLevels.add(new ArrayList<>());
        }
        topDownLevels.get(level).add(root.val);
        helper1(root.left, level + 1, topDownLevels);
        helper1(root.right, level + 1, topDownLevels);
    }

    /**
     * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/34981/My-DFS-and-BFS-java
     * -solution">DFS using LinkedList</a>
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        helper2(root, 0, ans);
        return ans;
    }

    private static void helper2(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(0, new LinkedList<>());
        }
        helper2(root.left, level + 1, ans);
        helper2(root.right, level + 1, ans);
        ans.get(ans.size() - level - 1).add(root.val);
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
