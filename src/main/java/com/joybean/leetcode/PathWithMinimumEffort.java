package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/path-with-minimum-effort/">Path With Minimum Effort</a>
 *
 * @author Joybean
 */
public class PathWithMinimumEffort {
    private final static int[] DIR = new int[] {0, 1, 0, -1, 0};

    /**
     * Dijkstra solution
     *
     * @param heights
     * @return
     */
    public static int minimumEffortPath1(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        //key:position(0...m*n-1),value:minimum effort from position 0 to position representing by
        // current key
        Map<Integer, Integer> minEffortMap = new HashMap<>();
        //Store unvisited positions
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(minEffortMap::get));
        queue.add(0);
        minEffortMap.put(0, 0);
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int minEffortPos = queue.poll();
            int row = minEffortPos / n;
            int col = minEffortPos % n;
            int minEffort = minEffortMap.get(minEffortPos);
            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                int adjacentPos = nr * n + nc;
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                int adjacentEffort = Math.max(Math.abs(heights[row][col] - heights[nr][nc]), minEffort);
                if (minEffortMap.getOrDefault(adjacentPos, Integer.MAX_VALUE) > adjacentEffort) {
                    minEffortMap.put(adjacentPos, adjacentEffort);
                    //May duplicated
                    queue.offer(adjacentPos);
                }
            }
        }
        return minEffortMap.get(m * n - 1);
    }

    /**
     * <a href="https://leetcode.com/problems/path-with-minimum-effort/discuss/909017/JavaPython-Dijikstra-Binary
     * -search-Clean-and-Concise">More concise Dijkstra solution</a>
     *
     * @param heights
     * @return
     */
    public static int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] minDist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // distance, row, col
        queue.offer(new int[] {0, 0, 0});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int d = top[0];
            int r = top[1];
            int c = top[2];
            //pruning,but not necessary
            if (d > minDist[r][c]) {
                continue;
            }
            // Reach to bottom right
            if (r == m - 1 && c == n - 1) {
                return d;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i];
                int nc = c + DIR[i + 1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (minDist[nr][nc] > newDist) {
                        minDist[nr][nc] = newDist;
                        //There could be one node with different distances in the queue
                        queue.offer(new int[] {minDist[nr][nc], nr, nc});
                    }
                }
            }
        }
        // Unreachable code
        return 0;
    }

    /**
     * Binary search
     * TODO
     *
     * @param heights
     * @return
     */
    public static int minimumEffortPath3(int[][] heights) {
        return 0;
    }

    /**
     * Bellman-Ford algorithm
     * TODO
     *
     * @param heights
     * @return
     */
    public static int minimumEffortPath4(int[][] heights) {
        return 0;
    }
}
