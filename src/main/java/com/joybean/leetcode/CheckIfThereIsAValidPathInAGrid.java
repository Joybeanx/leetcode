package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/">Check if There is a Valid Path in a
 * Grid</a>
 *
 * @author Joybean
 */
public class CheckIfThereIsAValidPathInAGrid {
    private static int[][][] nextDirections = {{{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}, {{0, -1}, {1, 0}}, {{0, 1}, {1,
        0}}, {{-1, 0}, {0, -1}}, {{-1, 0}, {0, 1}}};

    /**
     * <a href="https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/553574/Java-DFS
     * -Solution-Clean-code">DFS</a>
     *
     * @param grid
     * @return
     */
    public static boolean hasValidPath1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, grid, visited);
    }

    private static boolean dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] nextDirection : nextDirections[grid[i][j] - 1]) {
            int x = i + nextDirection[0];
            int y = j + nextDirection[1];
            if (x < 0 || x == m || y < 0 || y == n || visited[x][y]) {
                continue;
            }
            for (int[] backDirection : nextDirections[grid[x][y] - 1]) {
                if (x + backDirection[0] != i || y + backDirection[1] != j) {
                    continue;
                }
                if (dfs(x, y, m, n, grid, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Union Find
     * TODO
     *
     * @param grid
     * @return
     */
    public static boolean hasValidPath2(int[][] grid) {
        return false;
    }
}
