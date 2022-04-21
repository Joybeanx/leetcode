package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/sudoku-solver/">Sudoku Solver</a>
 *
 * @author Joybean
 */
public class SudokuSolver {

    /**
     * <a href="https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using
     * -Backtracking">backtracking</a>
     *
     * @param board
     */
    public static void solveSudoku1(char[][] board) {
        backtrack(board);
    }

    private static boolean backtrack(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char candidate = '1'; candidate <= '9'; candidate++) {
                    if (isValid(board, i, j, candidate)) {
                        board[i][j] = candidate;
                        if (backtrack(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                //Note here
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using
     * -Backtracking">Optimized backtracking (by cdai)</a>
     *
     * @param board
     */
    public static void solveSudoku2(char[][] board) {
        backtrack(board, 0, 0);
    }

    private static boolean backtrack(char[][] board, int row, int col) {
        for (int i = row; i < board.length; i++, col = 0) {
            for (int j = col; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char candidate = '1'; candidate <= '9'; candidate++) {
                    if (isValid(board, i, j, candidate)) {
                        board[i][j] = candidate;
                        if (backtrack(board, row, col + 1)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                //Note here
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int r, int c, char candidate) {
        int blockRowStart = (r / 3) * 3, blockColStart = (c / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == candidate || board[r][i] == candidate ||
                board[blockRowStart + i / 3][blockColStart + i % 3] == candidate) {
                return false;
            }
        }
        return true;
         /*
         for (char digit : board[r]) {
            if (digit == candidate) {
                return false;
            }
        }
        for (char[] row : board) {
            if (row[c] == candidate) {
                return false;
            }
        }
        int blockRowStart = (r / 3) * 3;
        int blockRowEnd = (r / 3 + 1) * 3;
        int blockColStart = (c / 3) * 3;
        int blockColEnd = (c / 3 + 1) * 3;
        for (int i = blockRowStart; i < blockRowEnd; i++) {
            for (int j = blockColStart; j < blockColEnd; j++) {
                if (board[i][j] == candidate) {
                    return false;
                }
            }
        }
        return true;
        */
    }

    /**
     * <a href="https://leetcode.com/problems/sudoku-solver/discuss/15796/Singapore-prime-minister-Lee-Hsien-Loong's
     * -Sudoku-Solver-code-runs-in-1ms">Lee Hsien Loong</a>
     * TODO
     *
     * @param board
     */
    public static void solveSudoku3(char[][] board) {
    }
}
