package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-tree-nodes/">Validate Binary Tree Nodes</a>
 *
 * @author Joybean
 */
public class ValidateBinaryTreeNodes {
    /**
     * Union Find
     *
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public static boolean validateBinaryTreeNodes1(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for (int node = 0; node < n; node++) {
            if (leftChild[node] != -1) {
                if (!uf.isValid(node, leftChild[node])) {
                    return false;
                }
                uf.union(node, leftChild[node]);
            }
            if (rightChild[node] != -1) {
                if (!uf.isValid(node, rightChild[node])) {
                    return false;
                }
                uf.union(node, rightChild[node]);
            }
        }
        //There should be exactly one node doesn't have parent
        return uf.count() == 1;
    }

    public static class UnionFind {
        private int[] parents;
        private int count;

        public UnionFind(int n) {
            this.count = n;
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        //Must make sure isValid(parent, child) before call this function
        public void union(int parent, int child) {
            parents[child] = parent;
            count--;
        }

        public int find(int x) {
            while (parents[x] != x) {
                x = parents[x];
            }
            return x;
        }

        public boolean isValid(int parent, int child) {
            //Child node must not have more than one parent
            if (parents[child] != child) {
                return false;
            }
            int root1 = find(parent);
            int root2 = find(child);
            //Detect cycles,case: 4, [1, -1, 0, -1], [-1, 3, -1, 2]
            return root1 != root2;
        }

        public int count() {
            return count;
        }
    }

    /**
     * DFS
     * TODO
     *
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public static boolean validateBinaryTreeNodes2(int n, int[] leftChild, int[] rightChild) {
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/validate-binary-tree-nodes/discuss/517557/C%2B%2B-Find-Root-%2B-DFS">Observation</a>
     * TODO
     *
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public static boolean validateBinaryTreeNodes3(int n, int[] leftChild, int[] rightChild) {
        return false;
    }
}
