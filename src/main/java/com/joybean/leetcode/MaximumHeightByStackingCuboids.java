package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-height-by-stacking-cuboids/">Maximum Height by Stacking Cuboids</a>
 *
 * @author Joybean
 */
public class MaximumHeightByStackingCuboids {
    /**
     * Iterative(bottom-up) DP
     *
     * @param cuboids
     * @return
     */
    public static int maxHeight1(int[][] cuboids) {
        Arrays.sort(cuboids, (a, b) -> b[0] * b[1] * b[2] - a[0] * a[1] * a[2]);
        int ans = 0;
        int n = cuboids.length;
        int[][] dp = new int[n + 1][3];
        dp[0] = new int[]{101, 101, 101};
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                for (int chd = 0; chd < 3; chd++) {
                    for (int phd = 0; phd < 3; phd++) {
                        if (canStack(dp, i, j, chd, phd, cuboids)) {
                            dp[i][chd] = Math.max(dp[j][phd] + cuboids[i - 1][chd], dp[i][chd]);
                            ans = Math.max(dp[i][chd], ans);
                        }
                    }
                }
            }
        }
        return ans - 101;
    }

    private static boolean canStack(int[][] dp, int curStack, int prevStack, int chd, int phd, int[][] cuboids) {
        if (prevStack == 0) {
            return true;
        }
        int[] curCuboid = cuboids[curStack - 1];
        int curHeight = curCuboid[chd];
        int[] prevCuboids = cuboids[prevStack - 1];
        int preHeight = prevCuboids[phd];
        if (curHeight > preHeight || dp[prevStack][phd] == 0) {
            return false;
        }
        int curWidth = curCuboid[(chd + 2) % 3];
        int curLength = curCuboid[(chd + 4) % 3];
        int preWidth = prevCuboids[(phd + 2) % 3];
        int preLength = prevCuboids[(phd + 4) % 3];
        return curWidth <= preWidth && curLength <= preLength || curWidth <= preLength && curLength <= preWidth;
    }
}
