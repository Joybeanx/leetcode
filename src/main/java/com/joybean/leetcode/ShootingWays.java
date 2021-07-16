package com.joybean.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There are 10 rings in the target. How many ways are there to hit to get m rings in total with n shots?
 *
 * @author Joybean
 */
public class ShootingWays {
    /**
     * Iterative(bottom-up) DP
     *
     * @param shots
     * @param totalRings
     * @return
     */
    public static int countShootingWays1(int shots, int totalRings) {
        if (totalRings > shots * 10) {
            return 0;
        }
        int[][] dp = new int[shots + 1][totalRings + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= shots; i++) {
            int maxRingsSoFar = Math.min(shots * 10, totalRings);
            for (int j = 0; j <= maxRingsSoFar; j++) {
                for (int n = 0; n <= 10; n++) {
                    if (j < n) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - n];
                }
            }
        }
        return dp[shots][totalRings];
    }

    /**
     * Recursive(top-down) DP with memo
     *
     * @param shots
     * @param totalRings
     * @return
     */
    public static int countShootingWays2(int shots, int totalRings) {
        return countShootingWaysInternal(shots, totalRings, new HashMap<>());
    }

    private static int countShootingWaysInternal(int shots, int totalRings, Map<List<Integer>, Integer> memo) {
        if (totalRings < 0 || shots < 0) {
            return 0;
        }

        if (shots == 1 && totalRings <= 10) {
            return 1;
        }
        List<Integer> memoKey = Arrays.asList(shots, totalRings);
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }
        int res = 0;
        for (int i = 0; i <= 10; i++) {
            res += countShootingWays1(shots - 1, totalRings - i);
        }
        memo.put(memoKey, res);
        return res;
    }
}
