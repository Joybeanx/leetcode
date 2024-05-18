package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/">Spiral Matrix</a>
 *
 * @author Joybean
 */
public class SpiralMatrix {
    /**
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        int i = 0;
        int j = 0;
        int dirChanged = 0;
        int total = m * n;
        while (true) {
            if (!visited[i][j]) {
                ans.add(matrix[i][j]);
                visited[i][j] = true;
                if (ans.size() == total) {
                    return ans;
                }
            }
            int dirIdx = dirChanged % 4;
            int ni = i + directions[dirIdx][0];
            int nj = j + directions[dirIdx][1];
            if (ni == m || ni == -1 || nj == n || nj == -1 || visited[ni][nj]) {
                dirChanged++;
                continue;
            }
            i = ni;
            j = nj;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/spiral-matrix/solutions/20599/super-simple-and-easy-to-understand-solution/"> (by GreatLim)</a>
     * TODO
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder2(int[][] matrix) {
        return null;
    }
}
