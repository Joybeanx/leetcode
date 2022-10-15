package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/frog-jump/">Frog Jump</a>
 *
 * @author Joybean
 */
public class FrogJump {
    /**
     * Iterative(bottom-up) DP:Time Limit Exceeded
     *
     * @param stones
     * @return
     */
    public static boolean canCross1(int[] stones) {
        int n = stones.length;
        //dp[i][j] represents requiring jump units if it jumps from stones[j] to stones[i]
        int[][] dp = new int[n][n];
        if (stones[1] != 1) {
            return false;
        }
        dp[1][0] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j > 0; j--) {
                int gap = stones[i] - stones[j];
                for (int k = 0; k < j; k++) {
                    int lastJump = dp[j][k];
                    if (lastJump == 0) {
                        continue;
                    }
                    if (Math.abs(lastJump - gap) <= 1) {
                        dp[i][j] = gap;
                        break;
                    }
                }
            }
        }
        for (int lastJump : dp[n - 1]) {
            if (lastJump > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Optimized iterative(bottom-up) DP
     *
     * @param stones
     * @return
     */
    public static boolean canCross2(int[] stones) {
        int n = stones.length;
        //dp[i] represents possible last jump units when reaches stones[i]
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            int k = 0;
            for (int j = i - 1; j >= 0; j--) {
                int gap = stones[i] - stones[j];
                for (int lastJump : dp[j]) {
                    if (j != 0 && lastJump == 0) {
                        break;
                    }
                    if (Math.abs(lastJump - gap) <= 1) {
                        dp[i][k++] = gap;
                        break;
                    }
                }
            }
        }
        return dp[n - 1][0] > 0;
    }

    /**
     * <a href="https://leetcode.com/problems/frog-jump/discuss/193816/Concise-and-fast-DP-solution-using-2D-array-instead-of-HashMap-with-text-and-video-explanation.">More concise iterative(bottom-up) DP (by anhongleetcode)</a>
     *
     * @param stones
     * @return
     */
    public static boolean canCross3(int[] stones) {
        int n = stones.length;
        //dp[i][j] represents there is a jump of size j successfully reaches stones[i]
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int gap = stones[i] - stones[j];
                if (gap >= n) {
                    continue;
                }
                if (dp[j][gap] || dp[j][gap - 1] || gap + 1 < n && dp[j][gap + 1]) {
                    dp[i][gap] = true;
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/frog-jump/discuss/193816/Concise-and-fast-DP-solution-using-2D-array-instead-of-HashMap-with-text-and-video-explanation.">More concise iterative(bottom-up) DP (by anhongleetcode)</a>
     *
     * @param stones
     * @return
     */
    public static boolean canCross4(int[] stones) {
        int n = stones.length;
        //dp[i][j] represents there is a jump of size j successfully reaches stones[i]
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int gap = stones[j] - stones[i];
                //pruning:the largest step to reach kth stone is k
                if (gap <= j) {
                    dp[j][gap] = dp[i][gap] || dp[i][gap + 1] || dp[i][gap - 1];
                    if (j == n - 1 && dp[j][gap]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/frog-jump/discuss/88824/Very-easy-to-understand-JAVA-solution-with-explanations"></a>
     * TODO
     *
     * @param stones
     * @return
     */
    public static boolean canCross5(int[] stones) {
        return false;
    }
}
