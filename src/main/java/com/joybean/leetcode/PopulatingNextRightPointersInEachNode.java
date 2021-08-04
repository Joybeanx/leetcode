package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Populating Next Right Pointers
 * in Each Node</a>
 *
 * @author Joybean
 */
public class PopulatingNextRightPointersInEachNode {
    /**
     * DFS:O(log n) space
     *
     * @param root
     * @return
     */
    public static Node connect1(Node root) {
        int height = getHeight(root);
        Node[] rightSides = new Node[height];
        connectInternal(root, 0, rightSides);
        return root;
    }

    private static int getHeight(Node root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }

    private static void connectInternal(Node root, int level, Node[] rightSides) {
        if (root == null) {
            return;
        }
        root.next = rightSides[level];
        rightSides[level] = root;
        connectInternal(root.right, level + 1, rightSides);
        connectInternal(root.left, level + 1, rightSides);
    }

    /**
     * DFS:O(1) space
     *
     * @param root
     * @return
     */
    public static Node connect2(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect2(root.left);
        connect2(root.right);
        return root;
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
