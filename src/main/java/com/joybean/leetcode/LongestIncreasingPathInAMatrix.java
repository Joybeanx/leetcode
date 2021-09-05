package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix/">Longest Increasing Path in a Matrix</a>
 *
 * @author Joybean
 */
public class LongestIncreasingPathInAMatrix {
    private static int ans;
    private static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    /**
     * DFS:Time Limit Exceeded
     *
     * @param matrix
     * @return
     */
    public static int longestIncreasingPath1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs1(i, j, 1, -1, matrix, visited);
            }
        }
        return ans;
    }

    private static void dfs1(int i, int j, int pathLength, int prev, int[][] matrix, boolean[][] visited) {
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (matrix[i][j] <= prev) {
            return;
        }
        visited[i][j] = true;
        ans = Math.max(pathLength, ans);
        for (int[] direction : directions) {
            dfs1(i + direction[0], j + direction[1], pathLength + 1, matrix[i][j], matrix, visited);
        }
        visited[i][j] = false;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78308/15ms-Concise-Java
     * -Solution">Optimized DFS</a>
     *
     * @param matrix
     * @return
     */
    public static int longestIncreasingPath2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(dfs2(i, j, -1, matrix, memo), ans);
            }
        }
        return ans;
    }

    private static int dfs2(int i, int j, int prev, int[][] matrix, int[][] memo) {
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || matrix[i][j] <= prev) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max = 0;
        for (int[] direction : directions) {
            max = Math.max(dfs2(i + direction[0], j + direction[1], matrix[i][j], matrix, memo) + 1, max);
        }
        memo[i][j] = max;
        return max;
    }

    /**
     * Topological sort via BFS
     * TODO
     *
     * @param matrix
     * @return
     */
    public static int longestIncreasingPath3(int[][] matrix) {
        return 0;
    }

}
