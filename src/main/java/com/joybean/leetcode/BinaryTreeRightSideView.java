package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right Side View</a>
 *
 * @author Joybean
 */
public class BinaryTreeRightSideView {
    /**
     * Level order traversal
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode rightMostNode = queue.peekLast();
            ans.add(rightMostNode.val);
            Deque<TreeNode> nextLevelQueue = new LinkedList<>();
            TreeNode nextLevelNode;
            while ((nextLevelNode = queue.poll()) != null) {
                if (nextLevelNode.left != null) {
                    nextLevelQueue.offer(nextLevelNode.left);
                }
                if (nextLevelNode.right != null) {
                    nextLevelQueue.offer(nextLevelNode.right);
                }
            }
            queue = nextLevelQueue;
        }
        return ans;
    }

    /**
     * Reverse level order traversal
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    ans.add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return ans;
    }


    /**
     * Reverse preorder traversal: use HashSet to track levels of which right most nodes has been found
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView3(TreeNode root) {
        Set<Integer> rightMostNodeFoundLevels = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        rightView(root, 0, rightMostNodeFoundLevels, ans);
        return ans;
    }

    private void rightView(TreeNode cur, int level, Set<Integer> rightMostNodeFoundLevels, List<Integer> ans) {
        if (cur == null) {
            return;
        }

        if (!rightMostNodeFoundLevels.contains(level)) {
            rightMostNodeFoundLevels.add(level);
            ans.add(cur.val);
        }
        rightView(cur.right, level + 1, rightMostNodeFoundLevels, ans);
        rightView(cur.left, level + 1, rightMostNodeFoundLevels, ans);
    }

    /**
     * <a href="https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)">
     * Reverse preorder traversal</a>
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView4(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        //Make sure the right most element of that level will be added the the result list
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
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
