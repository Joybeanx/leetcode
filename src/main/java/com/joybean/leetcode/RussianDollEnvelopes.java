package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/russian-doll-envelopes/">Russian Doll Envelopes</a>
 *
 * @author Joybean
 */
public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
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
        return Arrays.stream(dp).max().orElse(1);
    }
}