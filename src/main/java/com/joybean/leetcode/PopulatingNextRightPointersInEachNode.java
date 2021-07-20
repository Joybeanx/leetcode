package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Populating Next Right Pointers
 * in Each Node</a>
 *
 * @author Joybean
 */
public class PopulatingNextRightPointersInEachNode {
    //TODO
    public Node connect(Node root) {
        return null;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
