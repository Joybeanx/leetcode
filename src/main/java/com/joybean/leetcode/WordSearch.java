package com.joybean.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-search/">Word Search</a>
 *
 * @author Joybean
 */
public class WordSearch {

    public static boolean exist1(char[][] board, String word) {
        int firstChar = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == firstChar) {
                    Node startNode = new Node(i, j);
                    Set<Node> traversedNodes = new HashSet<>();
                    traversedNodes.add(startNode);
                    if (tryAdvance(startNode, 1, word, board, traversedNodes)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private static boolean tryAdvance(Node curNode, int index, String word, char[][] board, Set<Node> traversedNodes) {
        if (index > word.length() - 1) {
            return true;
        }
        int rows = board.length;
        int columns = board[curNode.x].length;
        char target = word.charAt(index);
        //Iterate possible adjacent nodes to find next matching node
        for (Node node : Arrays.asList(curNode.downNode(), curNode.upNode(), curNode.leftNode(), curNode.rightNode())) {
            if (node.x >= 0 && node.x < rows && node.y >= 0 && node.y < columns) {
                Set<Node> traversedNodesCopy = new HashSet<>(traversedNodes);
                if (board[node.x][node.y] == target && traversedNodesCopy.add(node)) {
                    if (tryAdvance(node, index + 1, word, board, traversedNodesCopy)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    static class Node {
        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Node upNode() {
            return new Node(x - 1, y);
        }

        Node downNode() {
            return new Node(x + 1, y);
        }

        Node leftNode() {
            return new Node(x, y - 1);
        }

        Node rightNode() {
            return new Node(x, y + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }


    /**
     * DFS using extra visited array
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist2(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (exist2(row, col, 0, new boolean[m][n], board, word)) {
                    return true;
                }

            }
        }
        return false;
    }


    private static boolean exist2(int row, int col, int wordIndex, boolean[][] visited, char[][] board, String word) {
        //wordIndex >= word.length() is unnecessary
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(wordIndex)) {
            return false;
        }
        //Mark this cell visited
        visited[row][col] = true;
        if (wordIndex == word.length() - 1) {
            return true;
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            if (exist2(row + direction[0], col + direction[1], wordIndex + 1, visited, board, word)) {
                return true;
            }
        }
        //Restore this cell to unvisited
        visited[row][col] = false;
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/word-search/solutions/27658/accepted-very-short-java-solution-no-additional-space/">DFS without extra space</a>
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist3(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (exist3(row, col, 0, board, word)) {
                    return true;
                }

            }
        }
        return false;
    }


    private static boolean exist3(int row, int col, int wordIndex, char[][] board, String word) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(wordIndex)) {
            return false;
        }
        //Mark this cell visited
        board[row][col] ^= 1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            if (exist3(row + direction[0], col + direction[1], wordIndex + 1, board, word)) {
                return true;
            }
        }
        //Apply XOR twice to get the original character back
        board[row][col] ^= 1;
        return false;
    }

}
