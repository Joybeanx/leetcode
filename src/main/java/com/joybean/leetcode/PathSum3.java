package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii/">Path Sum III</a>
 *
 * @author Joybean
 */
public class PathSum3 {
    private static int ans;

    /**
     * DFS
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum1(TreeNode root, int targetSum) {
        getPossiblePathSums(root, targetSum);
        return ans;
    }

    /**
     * Calculate possible path sums start with root
     *
     * @param root
     * @param targetSum
     * @return
     */
    private static List<Integer> getPossiblePathSums(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> leftPathSums = getPossiblePathSums(root.left, targetSum);
        List<Integer> rightPathSums = getPossiblePathSums(root.right, targetSum);
        List<Integer> totalPathSums = new ArrayList<>();
        totalPathSums.add(root.val);
        if (root.val == targetSum) {
            ans++;
        }
        for (List<Integer> pathSums : Arrays.asList(leftPathSums, rightPathSums)) {
            for (Integer pathSum : pathSums) {
                Integer newPathSum = pathSum + root.val;
                totalPathSums.add(newPathSum);
                if (newPathSum == targetSum) {
                    ans++;
                }
            }
        }
        return totalPathSums;
    }

    /**
     * <a href="https://leetcode.com/problems/path-sum-iii/discuss/91889/Simple-Java-DFS">Dual DFS</a><br/>
     * Time complexity analysis: pathSumFrom takes O(n)
     * <ul>
     *     <li>for balance tree,T(n) = n + 2T(n/2) = nlogn</li>
     *     <li>for linear tree,T(n) = n + T(n-1) = n^2 </li>
     * </ul>
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, targetSum) + pathSum2(root.left, targetSum) + pathSum2(root.right, targetSum);
    }

    private static Integer pathSumFrom(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        int nextTargetSum = targetSum - root.val;
        if (nextTargetSum == 0) {
            ans = 1;
        }
        ans += pathSumFrom(root.left, nextTargetSum) + pathSumFrom(root.right, nextTargetSum);
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method">DFS with
     * backtracking</a><br/>
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum3(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSum = new HashMap();
        prefixSum.put(0, 1);
        return helper(root, 0, targetSum, prefixSum);
    }

    public static int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        int res = prefixSum.getOrDefault(currSum - target, 0);
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, target, prefixSum) + helper(root.right, currSum, target, prefixSum);
        //Restore the map, as the recursion goes from the bottom to the top
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        return res;
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
