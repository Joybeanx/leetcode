package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/two-sum-bsts/">Two Sum BSTs</a>
 *
 * @author Joybean
 */
public class TwoSumBSTs {

    /**
     * <a href="https://lixinchengdu.github.io/algorithmbook/leetcode/two-sum-bsts.html">Two pointers</a>
     * TODO
     *
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left,
            TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
