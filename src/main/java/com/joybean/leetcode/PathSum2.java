package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
 *
 * @author Joybean
 */
public class PathSum2 {
    private static List<List<Integer>> ans = new ArrayList<>();

    /**
     * DFS without backtracking
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        pathSumInternal1(root, new ArrayList<>(), targetSum);
        return ans;
    }

    private static void pathSumInternal1(TreeNode root, List<Integer> curPath, int targetSum) {
        if (root == null) {
            return;
        }
        curPath.add(root.val);
        int nextTargetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (nextTargetSum == 0) {
                ans.add(curPath);
            }
            return;
        }
        //Use a copy of current path
        pathSumInternal1(root.left, new ArrayList<>(curPath), nextTargetSum);
        pathSumInternal1(root.right, new ArrayList<>(curPath), nextTargetSum);
    }

    /**
     * DFS without backtracking
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int nextTargetSum = targetSum - root.val;
        if (root.left == null && root.right == null && nextTargetSum == 0) {
            res.add(Arrays.asList(root.val));
            return res;
        }
        for (TreeNode child : Arrays.asList(root.left, root.right)) {
            List<List<Integer>> childPaths = pathSum2(child, nextTargetSum);
            for (List<Integer> childPath : childPaths) {
                //Merge current node and child paths
                List<Integer> newPath = new ArrayList<>();
                newPath.add(root.val);
                newPath.addAll(childPath);
                res.add(newPath);
            }
        }
        return res;
    }

    /**
     * DFS with backtracking
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> pathSum3(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumInternal3(root, targetSum, path, ans);
        return ans;
    }

    public static void pathSumInternal3(TreeNode root, int targetSum, List<Integer> curPath, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        curPath.add(root.val);
        int nextTargetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (nextTargetSum == 0) {
                //Must make a copy before adding to answer
                ans.add(new ArrayList<>(curPath));
            }
            return;
        }
        if (root.left != null) {
            pathSumInternal3(root.left, nextTargetSum, curPath, ans);
            curPath.remove(curPath.size() - 1);
        }
        if (root.right != null) {
            pathSumInternal3(root.right, nextTargetSum, curPath, ans);
            curPath.remove(curPath.size() - 1);
        }
    }

    /**
     * More concise DFS with backtracking
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> pathSum4(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        pathSumInternal4(root, curPath, targetSum, ans);
        return ans;
    }

    private static void pathSumInternal4(TreeNode root, List<Integer> curPath, int targetSum, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        curPath.add(root.val);
        int nextTargetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (nextTargetSum == 0) {
                //Must make a copy before adding to answer
                ans.add(new ArrayList<>(curPath));
            }
        }
        pathSumInternal4(root.left, curPath, nextTargetSum, ans);
        pathSumInternal4(root.right, curPath, nextTargetSum, ans);
        curPath.remove(curPath.size() - 1);
    }

    public static class TreeNode {
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
