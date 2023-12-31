package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/knight-dialer/">Knight Dialer</a>
 *
 * @author Joybean
 */
public class KnightDialer {
    private static int MOD = (int) 1e9 + 7;

    /**
     * Recursive(top-down) DP with memo
     *
     * @param n
     * @return
     */
    public static int knightDialer1(int n) {
        Map<Integer, List<Integer>> nextNums = new HashMap<>();
        nextNums.put(0, Arrays.asList(6, 4));
        nextNums.put(1, Arrays.asList(6, 8));
        nextNums.put(2, Arrays.asList(7, 9));
        nextNums.put(3, Arrays.asList(4, 8));
        nextNums.put(4, Arrays.asList(0, 3, 9));
        nextNums.put(5, new ArrayList<>());
        nextNums.put(6, Arrays.asList(0, 1, 7));
        nextNums.put(7, Arrays.asList(2, 6));
        nextNums.put(8, Arrays.asList(1, 3));
        nextNums.put(9, Arrays.asList(2, 4));
        int ans = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            ans = (ans + countDistinctNums1(i, nextNums, memo, n - 1)) % MOD;
        }
        return ans;
    }

    private static int countDistinctNums1(int fromNum, Map<Integer, List<Integer>> nextNums, Map<String, Integer> memo,
                                          int remain) {
        if (remain == 0) {
            return 1;
        }
        if (memo.containsKey(fromNum + "." + remain)) {
            return memo.get(fromNum + "." + remain);
        }
        int count = 0;
        for (int nextNum : nextNums.get(fromNum)) {
            count = (count + countDistinctNums1(nextNum, nextNums, memo, remain - 1)) % MOD;
        }
        memo.put(fromNum + "." + remain, count);
        return count;
    }

    /**
     * <a href="https://leetcode.com/problems/knight-dialer/editorial/">Optimized recursive(top-down) DP with memo</a>
     *
     * @param n
     * @return
     */
    public static int knightDialer2(int n) {
        int[][] jumps = {
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {3, 9, 0},
                {},
                {1, 7, 0},
                {2, 6},
                {1, 3},
                {2, 4}
        };
        int ans = 0;
        int[][] memo = new int[10][n + 1];
        for (int i = 0; i <= 9; i++) {
            ans = (ans + countDistinctNums2(i, jumps, memo, n - 1)) % MOD;
        }
        return ans;
    }

    private static int countDistinctNums2(int fromNum, int[][] jumps, int[][] memo, int remain) {
        if (remain == 0) {
            return 1;
        }
        if (memo[fromNum][remain] != 0) {
            return memo[fromNum][remain];
        }
        int count = 0;
        for (int nextNum : jumps[fromNum]) {
            count = (count + countDistinctNums2(nextNum, jumps, memo, remain - 1)) % MOD;
        }
        memo[fromNum][remain] = count;
        return count;
    }

    /**
     * <a href="https://leetcode.com/problems/knight-dialer/editorial/">Iterative(bottom-up) DP</a>
     * TODO
     *
     * @param n
     * @return
     */
    public static int knightDialer3(int n) {
        return 0;
    }
}
