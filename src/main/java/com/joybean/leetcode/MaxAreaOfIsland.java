package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/">Max Area of Island</a>
 *
 * @author Joybean
 */
public class MaxAreaOfIsland {
    /**
     * Union Find
     *
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int[] d : directions) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
                        continue;
                    }
                    uf.union(i * n + j, x * n + y);
                }
            }
        }
        return uf.getMaxSize();
    }

    public static class UnionFind {
        private int[] parents;
        private int[] sizes;
        private int maxSize;

        public UnionFind(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parents = new int[m * n];
            sizes = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int id = i * n + j;
                        parents[id] = id;
                        sizes[id] = 1;
                        //If there is only one land,union function will not be called,we must initialize maxSize here
                        maxSize = 1;
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
                maxSize = Math.max(sizes[root2], maxSize);
            } else {
                parents[root2] = root1;
                sizes[root1] += sizes[root2];
                maxSize = Math.max(sizes[root1], maxSize);
            }
        }

        public int find(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public int getMaxSize() {
            return maxSize;
        }
    }

    /**
     * DFS
     *
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(dfs(i, j, visited, grid), ans);
            }
        }
        return ans;
    }

    private static int dfs(int i, int j, boolean[][] visited, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int cnt = 1;
        for (int[] dir : directions) {
            cnt += dfs(i + dir[0], j + dir[1], visited, grid);
        }
        return cnt;
    }

    /**
     * BFS
     * TODO
     *
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland2(int[][] grid) {
        return 0;
    }


}
