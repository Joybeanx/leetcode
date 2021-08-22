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
     * DFS
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, Double> levelSumMap = new HashMap<>();
        Map<Integer, Integer> levelCountMap = new HashMap<>();
        List<Double> ans = new ArrayList<>();
        helper(root, 0, levelSumMap, levelCountMap);
        for (int i = 0; i < levelSumMap.size(); i++) {
            ans.add(levelSumMap.get(i) / levelCountMap.get(i));
        }
        return ans;
    }

    private void helper(TreeNode root, int level, Map<Integer, Double> levelSumMap,
        Map<Integer, Integer> levelCountMap) {
        if (root == null) {
            return;
        }
        levelSumMap.put(level, levelSumMap.getOrDefault(level, 0D) + root.val);
        levelCountMap.put(level, levelCountMap.getOrDefault(level, 0) + 1);
        helper(root.left, level + 1, levelSumMap, levelCountMap);
        helper(root.right, level + 1, levelSumMap, levelCountMap);
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
