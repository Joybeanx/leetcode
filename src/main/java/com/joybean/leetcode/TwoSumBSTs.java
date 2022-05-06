package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/two-sum-bsts/">Two Sum BSTs</a>
 *
 * @author Joybean
 */
public class TwoSumBSTs {

    /**
     * <a href="https://lixinchengdu.github.io/algorithmbook/leetcode/two-sum-bsts.html">Two pointers</a>
     *
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public static boolean twoSumBSTs1(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }
        int sum = root1.val + root2.val;
        if (sum == target) {
            return true;
        }
        if (sum < target) {
            if (twoSumBSTs1(root1.right, root2, target)) {
                return true;
            }
            if (twoSumBSTs1(root1, root2.right, target)) {
                return true;
            }
            return false;

        }
        if (twoSumBSTs1(root1.left, root2, target)) {
            return true;
        }
        if (twoSumBSTs1(root1, root2.left, target)) {
            return true;
        }
        return false;
    }

    /**
     * https://leetcode.jp/leetcode-1214-two-sum-bsts-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90
     * TODO
     *
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public static boolean twoSumBSTs2(TreeNode root1, TreeNode root2, int target) {
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
