package com.joybean.leetcode;

/**
 *
 * @author Joybean
 */
public class RoutesOfReturningToCircleOrigin {

    public static int routesOfReturningToCircleOrigin1(int nNodes, int steps) {
        if (steps == 0) {
            return 1;
        }
        int[][] dp = new int[steps][nNodes];
        dp[0][1] = 1;
        dp[0][9] = 1;
        for (int i = 1; i < steps - 1; i++) {
            for (int j = 0; j < nNodes; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + nNodes) % nNodes] + dp[i - 1][(j + 1) % nNodes];
            }
        }
        return dp[steps - 1][0];
    }
}