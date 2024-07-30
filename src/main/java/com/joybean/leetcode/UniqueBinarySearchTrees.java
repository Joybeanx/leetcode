package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees/">Unique Binary Search Trees</a>
 *
 * @author Joybean
 */
public class UniqueBinarySearchTrees {
    /**
     * <a href="https://leetcode.com/problems/unique-binary-search-trees/solutions/31666/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i/">Iterative(bottom-up) DP</a>
     *
     * @param n
     * @return
     */
    public static int numTrees1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //dp(n) = dp(0) * dp(n-1) + dp(1) * dp(n-2) + … + dp(n-1) * dp(0)
        //Sum of left*right combinations with different root
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] += dp[j] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * Recursive(top-down) DP with memo
     *
     * @param n
     * @return
     */
    public static int numTrees2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return numTrees2(n, memo);
    }

    private static int numTrees2(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += numTrees2(i - 1, memo) * numTrees2(n - i, memo);
        }
        memo[n] = ans;
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
