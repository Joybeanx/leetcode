package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Binary Tree Maximum Path Sum</a>
 *
 * @author Joybean
 */
public class BinaryTreeMaximumPathSum {
    //Initialize with minimum value rather than zero
    int ans = Integer.MIN_VALUE;

   /*
   //wrong solution: the path should not have forks
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxPathSum(root.left);
        int rightMax = maxPathSum(root.right);
        int max = root.val;
        max = Math.max(Math.max(Math.max(max + leftMax, max + rightMax), max + leftMax + rightMax), max);
        ans = Math.max(max, ans);
        return max;
    }
    */

    public int maxPathSum(TreeNode root) {
        oneSideMaxPathSum(root);
        return ans;
    }

    /**
     * Calculate max one side path sum start from root
     *
     * @param root
     * @return
     */
    private int oneSideMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // We don't use negative value
        int left = Math.max(0, oneSideMaxPathSum(root.left));
        int right = Math.max(0, oneSideMaxPathSum(root.right));
        //postorder traversal
        ans = Math.max(ans, left + right + root.val);
        //possible max path sum we can form involving root as parent:
        // 1. root itself
        // 2. max path sum from left
        // 3. max path sum from right
        // 4. sum(max path sum from left, max path sum from right, root.val)
        return Math.max(left + root.val, right + root.val);
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
