package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/">Find Mode in Binary Search Tree</a>
 *
 * @author Joybean
 */
public class FindModeInBinarySearchTree {
    private static List<Integer> ans = new ArrayList<>();
    private static int prev = Integer.MIN_VALUE;
    private static int count;
    private static int maxCount;

    public static int[] findMode1(TreeNode root) {
        helper(root);
        //Because tail nodes doesn't have a chance to update answer so we should do it again after traversal
        //For example: [1,null,2,2]
        updAns();
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev == root.val) {
            count++;
        } else {
            updAns();
            count = 1;
        }
        prev = root.val;
        helper(root.right);
    }

    private static void updAns() {
        if (maxCount == count) {
            ans.add(prev);
        } else if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(prev);
        }
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
