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
     * DP
     *
     * @param root
     * @return
     */
    public static int rob1(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }

    private static int robInternal(TreeNode node, Map<TreeNode, Integer> memo) {
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
            rob = rob + robInternal(left.left, memo) + robInternal(left.right, memo);
        }
        if (right != null) {
            rob = rob + robInternal(right.left, memo) + robInternal(right.right, memo);
        }
        int notRob = robInternal(left, memo) + robInternal(right, memo);
        int res = Math.max(rob, notRob);
        memo.put(node, res);
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
