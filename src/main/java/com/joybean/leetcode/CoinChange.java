package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">Coin Change</a>
 *
 * @author Joybean
 */
public class CoinChange {
    /**
     * Iterative(bottom-up) DP
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i < coin || dp[i - coin] < 0) {
                    continue;
                }
                if (dp[i] == -1) {
                    dp[i] = dp[i - coin] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }

    /**
     * Optimized iterative(bottom-up) DP
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //initialize array with amount+1
        Arrays.fill(dp, amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * <a
     * href="href="https://leetcode.com/problems/coin-change/solutions/77385/dp-ac-java-solution-18ms-beating-95/">Best
     * iterative(bottom-up) DP</a>
     *
     * @param coins
     * @param amount
     * @return
     * @see <a
     */
    public static int coinChange4(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //initialize array with amount+1
        Arrays.fill(dp, amount + 1);
        //put coins at outer loop to avoid some dp slots
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Recursive(top-down) DP
     * TODO
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange5(int[] coins, int amount) {
        return 0;
    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }


}
