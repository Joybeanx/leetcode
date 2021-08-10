package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        UnionFind uf = new UnionFind(grid2);
        //Store the points which represents land in grid2 but represents water in grid1
        List<Integer> extraLandsOfGrid2 = new ArrayList<>();
        int[][] distances = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (grid1[i][j] == 0) {
                        extraLandsOfGrid2.add(i * n + j);
                    }
                    for (int[] distance : distances) {
                        int x = i + distance[0];
                        int y = j + distance[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        Set<Integer> impossibleSubIslandRoots = new HashSet<>();
        for (int extraLand : extraLandsOfGrid2) {
            impossibleSubIslandRoots.add(uf.find(extraLand));
        }
        //number of all the grid2's islands -  number of impossible sub islands
        return uf.count() - impossibleSubIslandRoots.size();
    }

    /**
     * Flood Filling
     * TODO
     *
     * @param grid1
     * @param grid2
     * @return
     */
    public static int countSubIslands2(int[][] grid1, int[][] grid2) {
        return 0;
    }

    public static class UnionFind {
        private int[] parents;
        private int[] sizes;
        private int count;

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

        public int find(int x) {
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
