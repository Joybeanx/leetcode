package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/">Spiral Matrix</a>
 *
 * @author Joybean
 */
public class SpiralMatrix {
    /*
    //Time Limit Exceeded, dead loop occurs due to traverse num multiple times
    //case: [[1,2,3,4],[5,6,7,8],[9,10,11,12]], will add duplicate 6 at "ans.add(matrix[bottom][j])" because it break
    //the constraint: startRow <= endRow && startCol <= endCol
    public static List<Integer> spiralOrder1(int[][] matrix) {
         int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        List<Integer> ans = new ArrayList<>(m * n);
        while (ans.size() != m * n) {
            for (int col = startCol; col <= endCol; col++) {
                ans.add(matrix[startRow][col]);
            }
            startRow++;
            for (int row = startRow; row <= endRow; row++) {
                ans.add(matrix[row][endCol]);
            }
            endCol--;
            for (int col = endCol; col >= startCol; col--) {
                ans.add(matrix[endRow][col]);
            }
            endRow--;
            for (int row = endRow; row >= startRow; row--) {
                ans.add(matrix[row][startCol]);
            }
            startCol++;
        }
        return ans;
    }
    */


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
     * Traverse four directions and shrink [startRow,endRow] and [startCol,endCol]
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        List<Integer> ans = new ArrayList<>(m * n);
        while (ans.size() != m * n) {
            for (int col = startCol; col <= endCol; col++) {
                ans.add(matrix[startRow][col]);
            }
            if (ans.size() == m * n) {
                break;
            }
            startRow++;
            for (int row = startRow; row <= endRow; row++) {
                ans.add(matrix[row][endCol]);
            }
            if (ans.size() == m * n) {
                break;
            }
            endCol--;
            for (int col = endCol; col >= startCol; col--) {
                ans.add(matrix[endRow][col]);
            }
            if (ans.size() == m * n) {
                break;
            }
            endRow--;
            for (int row = endRow; row >= startRow; row--) {
                ans.add(matrix[row][startCol]);
            }
            startCol++;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/spiral-matrix/solutions/20599/super-simple-and-easy-to-understand-solution/">Change direction and shrink [startRow,endRow] and [startCol,endCol] (by nhunghgnguyen)</a>
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;
        int dir = 0;
        List<Integer> ans = new ArrayList<>(m * n);
        while (startRow <= endRow && startCol <= endCol) {
            switch (dir) {
                case 0:
                    for (int col = startCol; col <= endCol; col++) {
                        ans.add(matrix[startRow][col]);
                    }
                    startRow++;
                    break;
                case 1:
                    for (int row = startRow; row <= endRow; row++) {
                        ans.add(matrix[row][endCol]);
                    }
                    endCol--;
                    break;
                case 2:
                    for (int col = endCol; col >= startCol; col--) {
                        ans.add(matrix[endRow][col]);
                    }
                    endRow--;
                    break;
                case 3:
                    for (int row = endRow; row >= startRow; row--) {
                        ans.add(matrix[row][startCol]);
                    }
                    startCol++;
                    break;
            }
            dir = (dir + 1) % 4;
        }
        return ans;
    }
}
