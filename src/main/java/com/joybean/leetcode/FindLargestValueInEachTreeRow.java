package com.joybean.leetcode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">Find Largest Value in Each Tree Row</a>
 *
 * @author Joybean
 */
public class FindLargestValueInEachTreeRow {
    //TODO
    public List<Integer> largestValues(TreeNode root) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
