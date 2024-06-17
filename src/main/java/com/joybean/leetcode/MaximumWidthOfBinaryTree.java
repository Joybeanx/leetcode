package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">Maximum Width of Binary Tree</a>
 *
 * @author Joybean
 */
public class MaximumWidthOfBinaryTree {

    /**
     * Traverse tree twice: find left most nodes and right most nodes on each level fist, then calculate max width
     *
     * @param root
     * @return
     */
    public static int widthOfBinaryTree1(TreeNode root) {
        int ans = 0;
        // key:level value:left most node no on this level
        Map<Integer, Integer> letMostNodes = new HashMap<>();
        // key:level value:right most node no on this level
        Map<Integer, Integer> rightMostNodes = new HashMap<>();
        findLeftMostNodes(root, 0, 0, letMostNodes);
        findRightMostNodes(root, 0, 0, rightMostNodes);
        for (Integer level : letMostNodes.keySet()) {
            ans = Math.max(rightMostNodes.get(level) - letMostNodes.get(level) + 1, ans);
        }
        return ans;
    }

    private static void findLeftMostNodes(TreeNode root, int curNodeNo, int curLevel, Map<Integer, Integer> rightMostNodes) {
        if (root == null) {
            return;
        }
        if (!rightMostNodes.containsKey(curLevel)) {
            rightMostNodes.put(curLevel, curNodeNo);
        }
        findLeftMostNodes(root.left, 2 * curNodeNo + 1, curLevel + 1, rightMostNodes);
        findLeftMostNodes(root.right, 2 * curNodeNo + 2, curLevel + 1, rightMostNodes);
    }

    private static void findRightMostNodes(TreeNode cur, int curNodeNo, int curLevel, Map<Integer, Integer> rightMostNodes) {
        if (cur == null) {
            return;
        }
        if (!rightMostNodes.containsKey(curLevel)) {
            rightMostNodes.put(curLevel, curNodeNo);
        }
        findRightMostNodes(cur.right, 2 * curNodeNo + 2, curLevel + 1, rightMostNodes);
        findRightMostNodes(cur.left, 2 * curNodeNo + 1, curLevel + 1, rightMostNodes);
    }


    private static Integer ans = 0;

    /**
     * Traverse tree once: calculate max width in each recursion, use globle variable
     *
     * @param root
     * @return
     */
    public static int widthOfBinaryTree2(TreeNode root) {
        widthOfBinaryTree2(root, 0, 0, new ArrayList<>());
        return ans;
    }

    private static void widthOfBinaryTree2(TreeNode curNode, int curNodeNo, int curLevel, List<Integer> leftMostNodes) {
        if (curNode == null) {
            return;
        }
        if (curLevel == leftMostNodes.size()) {
            leftMostNodes.add(curNodeNo);
        }
        ans = Math.max(curNodeNo - leftMostNodes.get(curLevel) + 1, ans);
        widthOfBinaryTree2(curNode.left, 2 * curNodeNo + 1, curLevel + 1, leftMostNodes);
        widthOfBinaryTree2(curNode.right, 2 * curNodeNo + 2, curLevel + 1, leftMostNodes);
    }

    /**
     * <a href ="https://leetcode.com/problems/maximum-width-of-binary-tree/">Traverse tree once without global variable</a>
     *
     * @param root
     * @return
     */
    public static int widthOfBinaryTree3(TreeNode root) {
        return widthOfBinaryTree3(root, 0, 0, new ArrayList<>());
    }

    private static int widthOfBinaryTree3(TreeNode curNode, int curNodeNo, int curLevel, List<Integer> leftMostNodes) {
        if (curNode == null) {
            return 0;
        }
        if (curLevel == leftMostNodes.size()) {
            leftMostNodes.add(curNodeNo);
        }
        int leftMaxWidth = widthOfBinaryTree3(curNode.left, 2 * curNodeNo + 1, curLevel + 1, leftMostNodes);
        int rightMaxWidth = widthOfBinaryTree3(curNode.right, 2 * curNodeNo + 2, curLevel + 1, leftMostNodes);
        return Math.max(curNodeNo - leftMostNodes.get(curLevel) + 1, Math.max(leftMaxWidth, rightMaxWidth));
    }

    /**
     * BFS
     * TODO
     *
     * @param root
     * @return
     */
    public static int widthOfBinaryTree4(TreeNode root) {
        return 0;
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
