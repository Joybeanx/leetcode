package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Binary Tree Zigzag Level Order
 * Traversal</a>
 *
 * @author Joybean
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * Stack
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
     * Deque
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
