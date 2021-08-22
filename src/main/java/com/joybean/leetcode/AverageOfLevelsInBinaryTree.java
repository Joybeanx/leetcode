package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">Average of Levels in Binary Tree</a>
 *
 * @author Joybean
 */
public class AverageOfLevelsInBinaryTree {
    /**
     * DFS using two maps
     *
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels1(TreeNode root) {
        Map<Integer, Double> levelSumMap = new HashMap<>();
        Map<Integer, Integer> levelCountMap = new HashMap<>();
        List<Double> ans = new ArrayList<>();
        helper(root, 0, levelSumMap, levelCountMap);
        for (int i = 0; i < levelSumMap.size(); i++) {
            ans.add(levelSumMap.get(i) / levelCountMap.get(i));
        }
        return ans;
    }

    private static void helper(TreeNode root, int level, Map<Integer, Double> levelSumMap,
        Map<Integer, Integer> levelCountMap) {
        if (root == null) {
            return;
        }
        levelSumMap.put(level, levelSumMap.getOrDefault(level, 0D) + root.val);
        levelCountMap.put(level, levelCountMap.getOrDefault(level, 0) + 1);
        helper(root.left, level + 1, levelSumMap, levelCountMap);
        helper(root.right, level + 1, levelSumMap, levelCountMap);
    }

    /**
     * <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/">>DFS using two lists</a>
     *
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels2(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }

    public static void average(TreeNode node, int level, List<Double> sum, List<Integer> count) {
        if (node == null) {
            return;
        }
        if (level < sum.size()) {
            sum.set(level, sum.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        } else {
            sum.add(1.0 * node.val);
            count.add(1);
        }
        average(node.left, level + 1, sum, count);
        average(node.right, level + 1, sum, count);
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels3(TreeNode root) {
        return null;
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
