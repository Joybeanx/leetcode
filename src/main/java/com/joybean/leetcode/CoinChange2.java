package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/coin-change-2/">Coin Change 2</a>
 *
 * @author Joybean
 */
public class CoinChange2 {
    /**
     * iterative(bottom-up) DP
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int change1(int amount, int[] coins) {
        //dp[i][j] represents the number of combinations to make up amount j by using the first i types of coins
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            int coin = coins[i - 1];
            //Start from 1 not coin
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coin) {
                    dp[i][j] += dp[i][j - coin];
                }
            }
        }
        return dp[coins.length][amount];
    }

    /**
     * iterative(bottom-up) DP with state compression
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //The order makes no difference when we use a 2-dimensional array,
        //but we must put coin in the outer loop when we use 1-dimensional array
        //https://leetcode.com/problems/coin-change-2/discuss/176706/Beginner-Mistake%3A-Why-an-inner-loop-for-coins
        // -doensn't-work-Java-Soln @Zephyr_96
        for (int i = 1; i <= coins.length; i++) {
            dp[0] = 1;
            int coin = coins[i - 1];
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    /**
     * recursive(top-down) DP with memo
     * TODO
     * @param coins
     * @param amount
     * @return
     */
    public static int change3(int amount, int[] coins) {
       return 0;
    }
}
