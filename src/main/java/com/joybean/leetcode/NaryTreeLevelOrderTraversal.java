package com.joybean.leetcode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-level-order-traversal/">N-ary Tree Level Order Traversal</a>
 *
 * @author Joybean
 */
public class NaryTreeLevelOrderTraversal {
    //TODO
    public List<List<Integer>> levelOrder(Node root) {
        return null;
    }

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
