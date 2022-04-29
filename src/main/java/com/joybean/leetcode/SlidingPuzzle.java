package com.joybean.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/sliding-puzzle/">Sliding Puzzle</a>
 *
 * @author Joybean
 */
public class SlidingPuzzle {
    /**
     * <a href="https://leetcode.com/problems/sliding-puzzle/discuss/146652/Java-8ms-BFS-with-algorithm-explained">BFS</a>
     *
     * @param board
     * @return
     */
    public static int slidingPuzzle1(int[][] board) {
        int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String target = "123450";
        String initial = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                initial += board[i][j];
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(initial);
        Set<String> visited = new HashSet<>();
        visited.add(initial);
        int move = 0;
        while (!queue.isEmpty()) {
            int loop = queue.size();
            for (int i = 0; i < loop; i++) {
                String curBoard = queue.poll();
                if (curBoard.equals(target)) {
                    return move;
                }
                int blankPos = curBoard.indexOf('0');
                for (int neighbor : neighbors[blankPos]) {
                    char[] chars = curBoard.toCharArray();
                    chars[blankPos] = chars[neighbor];
                    chars[neighbor] = '0';
                    String newBoard = new String(chars);
                    if (!visited.contains(newBoard)) {
                        queue.add(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            move++;
        }
        return -1;
    }

    /**
     * Bidirectional BFS
     * TODO
     *
     * @param board
     * @return
     */
    public static int slidingPuzzle2(int[][] board) {
        return 0;
    }
}
