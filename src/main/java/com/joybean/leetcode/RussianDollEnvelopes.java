package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/russian-doll-envelopes/">Russian Doll Envelopes</a>
 *
 * @author Joybean
 */
public class RussianDollEnvelopes {
    /**
     * DP
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes1(int[][] envelopes) {
        //pre handling:convert to LIS problem
        //case: {4, 5}, {4, 6}, {6, 7}, {2, 3}
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (greaterThan(i, j, envelopes)) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    public static int maxEnvelopes2(int[][] envelopes) {
        //pre handling:order by weight asc,height desc
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] heights = Arrays.stream(envelopes).map(h -> h[1]).mapToInt(Integer::intValue).toArray();
        int[] dp = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (heights[i] > heights[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    private static boolean greaterThan(int i, int j, int[][] envelopes) {
        return envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0];
    }

    /**
     * TODO
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes3(int[][] envelopes) {
        return 0;
    }
}