package com.joybean.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/detect-cycles-in-2d-grid/">Detect Cycles in 2D Grid</a>
 *
 * @author Joybean
 */
public class DetectCyclesIn2DGrid {
    /**
     * Union Find
     *
     * @param grid
     * @return
     */
    public static boolean containsCycle1(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                letters.add(grid[i][j]);
            }
        }
        for (Character letter : letters) {
            UnionFind uf = new UnionFind(grid, letter);
            //Only go forward and downward
            int[][] distances = {{1, 0}, {0, 1}};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == letter) {
                        for (int[] distance : distances) {
                            int x = i + distance[0];
                            int y = j + distance[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == letter) {
                                int id1 = i * n + j;
                                int id2 = x * n + y;
                                if (uf.hasSameRoot(id1, id2)) {
                                    return true;
                                }
                                uf.union(id1, id2);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static class UnionFind {
        private int[] parents;
        private int[] sizes;

        public UnionFind(char[][] grid, char target) {
            int m = grid.length;
            int n = grid[0].length;
            parents = new int[m * n];
            sizes = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == target) {
                        int id = i * n + j;
                        parents[id] = id;
                        sizes[id] = 1;
                    }
                }
            }
        }

        public boolean hasSameRoot(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            return root1 == root2;
        }

        public void union(int x, int y) {
            //If we implements this by parents[y] = x，we would not get the right answer,
            //think about this case:{{'b', 'c', 'a', 'a'}, {'d', 'a', 'a', 'a'}, {'a', 'b', 'a', 'c'}}
            int root1 = find(x);
            int root2 = find(y);
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
