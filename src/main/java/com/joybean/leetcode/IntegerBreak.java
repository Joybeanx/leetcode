package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/integer-break/">Integer Break</a>
 *
 * @author Joybean
 */
public class IntegerBreak {
    /**
     * <a href="https://leetcode.com/problems/integer-break/discuss/80694/Java-DP-solution">Iterative(bottom-up) DP (by kvmial)</a>
     *
     * @param n
     * @return
     */
    public static int integerBreak1(int n) {
        //dp[i] represents the maximum product of i
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }

    /**
     * <a href="https://leetcode.com/problems/integer-break/discuss/80694/Java-DP-solution">Optimized iterative(bottom-up) DP: init dp array first (by cdai)</a>
     *
     * @param n
     * @return
     */
    public static int integerBreak2(int n) {
        //dp[i] represents the maximum product of i
        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[j] * dp[i - j], dp[i]);
            }
        }
        return dp[n];
    }

    /**
     * <a href="https://leetcode.com/problems/integer-break/discuss/80689/A-simple-explanation-of-the-math-part-and-a-O(n)-solution">Math</a>
     * TODO
     * @param n
     * @return
     */
    public static int integerBreak3(int n) {
        return 0;
    }

}
