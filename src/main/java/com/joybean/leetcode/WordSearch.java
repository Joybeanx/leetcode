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

    public static boolean exist2(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    /**
     * No extra space
     * @param board
     * @param y
     * @param x
     * @param word
     * @param i
     * @return
     */
    private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x + 1, word, i + 1)
                || exist(board, y, x - 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1)
                || exist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        return exist;
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
                    if (tryAdvance(node, index+1, word, board, traversedNodesCopy)) {
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

}
