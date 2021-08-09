package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/count-sub-islands/">Count Sub Islands</a>
 *
 * @author Joybean
 */
public class CountSubIslands {
    /**
     * Union Find
     *
     * @param grid2
     * @param grid2
     * @return
     */
    public static int countSubIslands1(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        UnionFind uf1 = new UnionFind(grid2);
        int[][] distances = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    for (int[] distance : distances) {
                        int x = i + distance[0];
                        int y = j + distance[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
                            uf1.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }

        UnionFind uf2 = new UnionFind(grid1, grid2);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    for (int[] distance : distances) {
                        int x = i + distance[0];
                        int y = j + distance[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
                            uf2.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        return uf1.count() - uf2.count();
    }

    public static class UnionFind {
        private int[] parents;
        private int[] sizes;
        private int count;

        public UnionFind(int[][] grid1, int[][] grid2) {
            int m = grid1.length;
            int n = grid1[0].length;
            this.count = 0;
            parents = new int[m * n];
            sizes = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1 && (grid1[i][j] == 0 || i >= 1 && parents[(i - 1) * n + j] != 0
                        || i + 1 < m && parents[(i + 1) * n + j] != 0 || j + 1 < n && parents[i * n + j + 1] != 0
                        || j >= 1 && parents[i * n + j - 1] != 0)) {
                        int id = i * n + j;
                        parents[id] = id;
                        sizes[i] = 1;
                        count++;
                    } else {
                        grid2[i][j] = 0;
                    }
                }
            }
        }

        public UnionFind(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            this.count = 0;
            parents = new int[m * n];
            sizes = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
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

    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0},
            {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands1(grid1, grid2));
    }
}
