package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">Maximum Length of Pair Chain</a>
 *
 * @author Joybean
 */
public class MaximumLengthOfPairChain {
    /**
     * Iterative(bottom-up) DP
     *
     * @param pairs
     * @return
     */
    public static int findLongestChain1(int[][] pairs) {
        //It doesn't matter if you sort by pair.left or pair.right in DP solution.
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        //dp[i] stores length of the longest chain that ends with pairs[i]
        int[] dp = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/225801/Proof-of-the-greedy-solution">Greedy</a>
     * TODO
     *
     * @param pairs
     * @return
     */
    public static int findLongestChain2(int[][] pairs) {
        //We must sort by pair.right first
        return 0;
    }
}
