package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-binary-tree/">Maximum Binary Tree</a>
 *
 * @author Joybean
 */
public class MaximumBinaryTree {
    /**
     * Recursive solution
     *
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree1(int[] nums) {
        return constructMaximumBinaryTree1(0, nums.length - 1, nums);
    }

    private static TreeNode constructMaximumBinaryTree1(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int maxIdx = findMaxIdx(left, right, nums);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructMaximumBinaryTree1(left, maxIdx - 1, nums);
        root.right = constructMaximumBinaryTree1(maxIdx + 1, right, nums);
        return root;
    }

    private static int findMaxIdx(int left, int right, int[] nums) {
        int maxIdx = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution">Stack
     * solution</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree2(int[] nums) {
        return null;
    }

    public static void main(String[] args) {
        int[] s1 = {1, 3, 2, 4, 6, 0, 5};
        int[] s2 = {1};
        int[] s3 = {1, 5, 2, 3, 6};
        TreeNode tree1 = constructMaximumBinaryTree1(s1);
        TreeNode tree2 = constructMaximumBinaryTree1(s2);
        TreeNode tree3 = constructMaximumBinaryTree1(s3);
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
