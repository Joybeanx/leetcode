package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/">Rotting Oranges</a>
 *
 * @author Joybean
 */
public class RottingOranges {
    /**
     * BFS using list
     *
     * @param grid
     * @return
     */
    public static int orangesRotting1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int changed = 0;
        int ans = 0;
        while (!list.isEmpty()) {
            List<int[]> nextRotten = new ArrayList<>();
            for (int[] each : list) {
                for (int[] direction : directions) {
                    int newRow = each[0] + direction[0];
                    int newCol = each[1] + direction[1];
                    if (check(newRow, newCol, grid)) {
                        grid[newRow][newCol] = 2;
                        nextRotten.add(new int[] {newRow, newCol});
                    }
                }
            }
            list = nextRotten;
            changed += nextRotten.size();
            if (!nextRotten.isEmpty()) {
                ans++;
            }
        }
        return changed == fresh ? ans : -1;
    }

    /**
     * <a
     * href="https://leetcode.com/problems/rotting-oranges/solutions/238681/java-clean-bfs-solution-with-comments/">BFS
     * using queue</a>
     *
     * @param grid
     * @return
     */
    public static int orangesRotting2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int ans = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] direction : directions) {
                    int newRow = pos[0] + direction[0];
                    int newCol = pos[1] + direction[1];
                    if (check(newRow, newCol, grid)) {
                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
            ans++;
        }
        return fresh == 0 ? ans - 1 : -1;
    }

    private static boolean check(int i, int j, int[][] grid) {
        if (i < 0 || i == grid.length) {
            return false;
        }
        if (j < 0 || j == grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        return false;
    }
}
