package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a>
 *
 * @author Joybean
 */
public class UniquePaths {
    /**
     * Iterative(bottom-up) DP using two-dimensional array
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        //dp[i][j] represents unique paths numbers that the robot move from point (1,1) to point(i,j)
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }


    /**
     * Iterative(bottom-up) DP using two-dimensional array
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1 || j != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }



    /**
     * Iterative(bottom-up) DP using two-dimensional array: initialize dp[0][j] and dp[i][0]
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths3(int m, int n) {
        //dp[i][j] represents unique paths numbers that the robot move from point (0,0) to point(i,j)
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Iterative(bottom-up) DP with state compression 1
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths4(int m, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n];
    }

    /**
     * Iterative(bottom-up) DP with state compression 2
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths5(int m, int n) {
        //dp[j] represents unique paths numbers that the robot move from point (0,0) to point(i,j)
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
