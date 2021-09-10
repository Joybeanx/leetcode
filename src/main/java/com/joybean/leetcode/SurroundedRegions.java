package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/surrounded-regions/">Surrounded Regions</a>
 *
 * @author Joybean
 */
public class SurroundedRegions {
    /**
     * Union Find
     *
     * @param board
     */
    public static void solve1(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(board);
        int dummy = m * n;
        //Only go forward and downward
        int[][] distances = {{1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    for (int[] distance : distances) {
                        int x = i + distance[0];
                        int y = j + distance[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
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
                if (board[i][j] == 'O') {
                    if (!uf.isConnected(i * n + j, dummy)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public static class UnionFind {
        private int[] parents;
        private int[] sizes;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parents = new int[m * n + 1];
            sizes = new int[m * n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'O') {
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

    /**
     * DFS
     * TODO
     *
     * @param board
     */
    public static void solve2(char[][] board) {
    }
}
