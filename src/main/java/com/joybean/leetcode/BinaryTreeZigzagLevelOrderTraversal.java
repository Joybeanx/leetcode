package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Binary Tree Zigzag Level Order
 * Traversal</a>
 *
 * @author Joybean
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * BFS using Stack
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; ; i++) {
            List<Integer> levelList = new ArrayList<>();
            Stack<TreeNode> levelStack = new Stack<>();
            if (stack.isEmpty()) {
                break;
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                levelList.add(node.val);
                //Push children nodes to level stack so that we can pop element in next outer loop as needed
                //Much better if using flag
                if ((i & 1) == 1) {
                    pushNodes(levelStack, node.left, node.right);
                } else {
                    pushNodes(levelStack, node.right, node.left);
                }
            }
            stack = levelStack;
            ans.add(levelList);
        }
        return ans;
    }

    private static void pushNodes(Stack<TreeNode> levelStack, TreeNode... nodes) {
        Arrays.stream(nodes).filter(Objects::nonNull).forEach(levelStack::push);
    }

    /**
     * BFS using Deque: poll/offer from two sides
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = null;
                if (((ans.size()) & 1) == 0) {
                    cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                } else {
                    cur = queue.pollLast();
                    if (cur.right != null) {
                        queue.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.offerFirst(cur.left);
                    }
                }

                levelNodes.add(cur.val);
            }
            ans.add(levelNodes);
        }
        return ans;
    }

    /**
     * BFS using Queue: add levelNodes from two directions
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if ((ans.size() & 1) == 0) {
                    levelNodes.add(cur.val);
                } else {
                    levelNodes.addFirst(cur.val);
                }

            }
            ans.add(levelNodes);
        }
        return ans;
    }

    public static void main(String[] args) {
        zigzagLevelOrder3(new TreeNode(3, new TreeNode(9), new TreeNode(20)));
    }

    /**
     * DFS
     * TODO
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder4(TreeNode root) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
