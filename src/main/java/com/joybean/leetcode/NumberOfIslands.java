package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 *
 * @author Joybean
 */
public class NumberOfIslands {
    /**
     * <a href="https://leetcode.com/problems/number-ofa-islands/discuss/56354/1D-Union-Find-Java-solution-easily-generalized
     * -to-other-problems">Union Find</a>
     *
     * @param grid
     * @return
     */
    public static int numIslands1(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int[][] distances = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] distance : distances) {
                        int x = i + distance[0];
                        int y = j + distance[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        return uf.count();
    }

    public static class UnionFind {
        private int[] parents;
        private int[] sizes;
        private int count;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            this.count = 0;
            parents = new int[m * n];
            sizes = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        parents[id] = id;
                        sizes[i] = 1;
                        count++;
                    }
                }
            }
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
            count--;
        }

        private int find(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }
}
