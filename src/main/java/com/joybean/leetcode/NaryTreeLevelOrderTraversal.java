package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-level-order-traversal/">N-ary Tree Level Order Traversal</a>
 *
 * @author Joybean
 */
public class NaryTreeLevelOrderTraversal {
    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private static void helper(Node node, int level, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        if (node.children == null) {
            return;
        }
        for (Node child : node.children) {
            helper(child, level + 1, ans);
        }
    }

    /**
     * BFS using List:Time Limit Exceeded
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Node> children = root.children;
        while (children != null) {
            List<Integer> levelValues = new ArrayList<>();
            List<Node> nextChildren = new ArrayList<>();
            for (Node child : children) {
                levelValues.add(child.val);
                if (child.children != null) {
                    nextChildren.addAll(child.children);
                }
            }
            ans.add(levelValues);
            children = nextChildren;
        }
        return ans;
    }

    /**
     * BFS using Queue
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                levelNodes.add(queue.peek().val);
                queue.addAll(queue.poll().children);
            }
            res.add(levelNodes);
        }
        return res;
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
