package com.joybean.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/count-the-number-of-ideal-arrays/">Count the Number of Ideal Arrays</a>
 *
 * @author Joybean
 */
public class CountTheNumberOfIdealArrays {

    /**
     * Time Limit Exceeded
     *
     * @param n
     * @param maxValue
     * @return
     */
    public static int idealArrays1(int n, int maxValue) {
        int ans = 0;
        int mod = (int) 1e9 + 7;
        //dp[i][j] represents the number of distinct ideal arrays of length i which ends with max value j
        int[][] dp = new int[n + 1][maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                for (int k = 1; k <= j; k++) {
                    if (j % k == 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
                if (i == n) {
                    ans = (ans + dp[i][j]) % mod;
                }
            }

        }
        return ans;
    }

    /**
     * Memory Limit Exceeded
     *
     * @param n
     * @param maxValue
     * @return
     */
    public static int idealArrays2(int n, int maxValue) {
        int ans = 0;
        int mod = (int) 1e9 + 7;
        //dp[i][j] represents the number of distinct ideal arrays of length i which ends with max value j
        int[][] dp = new int[n + 1][maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                for (int k = 1; k * j < dp[0].length; k++) {
                    dp[i][k * j] = (dp[i][k * j] + dp[i - 1][j]) % mod;
                }
            }

        }
        for (int i = 1; i < dp[0].length; i++) {
            ans = (ans + dp[n][i]) % mod;
        }
        return ans;
    }

    /**
     * Time Limit Exceeded
     *
     * @param n
     * @param maxValue
     * @return
     */
    public static int idealArrays3(int n, int maxValue) {
        int ans = 0;
        int mod = (int) 1e9 + 7;
        //dp[i] represents the number of distinct ideal arrays which ends with max value i
        int[] dp = new int[maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[i] = 1;
        }
        int[] prev = dp;
        for (int i = 2; i <= n; i++) {
            int[] cur = new int[maxValue + 1];
            for (int j = 1; j <= maxValue; j++) {
                for (int k = 1; k * j <= maxValue; k++) {
                    cur[k * j] = (cur[k * j] + prev[j]) % mod;
                }
            }
            prev = cur;
        }
        for (int i = 1; i <= maxValue; i++) {
            ans = (ans + prev[i]) % mod;
        }
        return ans;
    }

    /**
     * Time Limit Exceeded
     *
     * @param n
     * @param maxValue
     * @return
     */
    public static int idealArrays4(int n, int maxValue) {
        int ans = 0;
        int mod = (int) 1e9 + 7;
        //dp[i] represents the number of distinct ideal arrays which ends with max value i
        int[] dp = new int[maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[i] = 1;
        }
        // i and its multiples
        Map<Integer, Set<Integer>> multipleMap = new HashMap<>();
        for (int i = 1; i <= maxValue; i++) {
            for (int k = 1; k * i <= maxValue; k++) {
                Set<Integer> set = multipleMap.getOrDefault(k * i, new HashSet<>());
                set.add(i);
                multipleMap.put(k * i, set);
            }
        }
        int[] prev = dp;
        for (int i = 2; i <= n; i++) {
            int[] cur = new int[maxValue + 1];
            for (Map.Entry<Integer, Set<Integer>> entry : multipleMap.entrySet()) {
                Integer key = entry.getKey();
                for (Integer v : entry.getValue()) {
                    cur[key] = (cur[key] + prev[v]) % mod;
                }
            }
            prev = cur;
        }
        for (int i = 1; i <= maxValue; i++) {
            ans = (ans + prev[i]) % mod;
        }
        return ans;
    }

    /**
     * TODO
     *
     * @param n
     * @param maxValue
     * @return
     */
    public static int idealArrays5(int n, int maxValue) {
        return 0;
    }
}
