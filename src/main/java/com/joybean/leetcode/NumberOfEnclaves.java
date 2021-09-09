package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/number-of-enclaves/">Number of Enclaves</a>
 *
 * @author Joybean
 */
public class NumberOfEnclaves {
    public static int numEnclaves1(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int dummy = m * n;
        //Only go forward and downward
        int[][] distances = {{1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] distance : distances) {
                        int x = i + distance[0];
                        int y = j + distance[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                    //Connect border cells with the edge
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        uf.union(i * n + j, dummy);
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1) {
                    if (!uf.isConnected(i * n + j, dummy)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static class UnionFind {
        private int[] parents;
        private int[] sizes;

        public UnionFind(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parents = new int[m * n + 1];
            sizes = new int[m * n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int id = i * n + j;
                        parents[id] = id;
                        sizes[id] = 1;
                    }
                }
            }
            int dummy = m * n;
            parents[dummy] = dummy;
            sizes[dummy] = 1;
        }

        public boolean isConnected(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            if (root1 == root2) {
                return true;
            }
            return false;
        }

        public void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            if (root1 == root2) {
                return;
            }
            if (sizes[root1] < sizes[root2]) {
                parents[root1] = root2;
                sizes[root2] += sizes[root1];
            } else {
                parents[root2] = root1;
                sizes[root1] += sizes[root2];
            }
        }

        public int find(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }
    }
}
