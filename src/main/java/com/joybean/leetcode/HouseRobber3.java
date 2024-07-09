package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/house-robber-iii/">House Robber III</a>
 *
 * @author Joybean
 */
public class HouseRobber3 {
    /**
     * Recursive(top-down) DP with memo
     *
     * @param root
     * @return
     */
    public static int rob1(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return rob(root, memo);
    }

    private static int rob(TreeNode node, Map<TreeNode, Integer> memo) {
        if (node == null) {
            return 0;
        }
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        int rob = node.val;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null) {
            rob = rob + rob(left.left, memo) + rob(left.right, memo);
        }
        if (right != null) {
            rob = rob + rob(right.left, memo) + rob(right.right, memo);
        }
        int skip = rob(left, memo) + rob(right, memo);
        int ans = Math.max(rob, skip);
        memo.put(node, ans);
        return ans;
    }

    /**
     * Greedy algorithm
     * TODO
     *
     * @param root
     * @return
     */
    public static int rob2(TreeNode root) {
        return 0;
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
