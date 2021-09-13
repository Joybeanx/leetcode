package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">Number of Provinces</a>
 *
 * @author Joybean
 */
public class NumberOfProvinces {
    /**
     * Union Find
     *
     * @param isConnected
     * @return
     */
    public static int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    public static class UnionFind {
        private int[] parents;
        private int[] sizes;
        private int count;

        public UnionFind(int n) {
            parents = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
            count = n;
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
            count--;
        }

        public int find(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public int getCount() {
            return count;
        }
    }

    /**
     * DFS
     *
     * @param isConnected
     * @return
     */
    public static int findCircleNum2(int[][] isConnected) {
        return 0;
    }
}
