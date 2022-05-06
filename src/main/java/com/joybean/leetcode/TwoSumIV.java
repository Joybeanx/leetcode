package com.joybean.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">Two Sum IV - Input is a BST</a>
 *
 * @author Joybean
 */
public class TwoSumIV {
    private static Set<Integer> set = new HashSet<>();

    /**
     * Two pointers
     *
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget1(TreeNode root, int k) {
        return containsTarget1(root, root, k);
    }

    private static boolean containsTarget1(TreeNode root1, TreeNode root2, int k) {
        if (root1 == null || root2 == null) {
            return false;
        }
        int sum = root1.val + root2.val;
        if (sum == k && root1 != root2) {
            return true;
        }
        if (sum > k) {
            return containsTarget1(root1.left, root2, k) || containsTarget1(root1, root2.left, k);
        }
        return containsTarget1(root1.right, root2, k) || containsTarget1(root1, root2.right, k);
    }

    /**
     * < a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059/JavaC%2B%2B-Three-simple
     * -methods-choose-one-you-like">Two pointers 2</a>
     * TODO
     *
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget2(TreeNode root, int k) {
        return false;
    }

    /**
     * Use set
     *
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget3(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget3(root.left, k) || findTarget3(root.right, k);
    }

    /**
     * <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059/JavaC%2B%2B-Three-simple
     * -methods-choose-one-you-like">Inorder traversal + Two pointers</a>
     * TODO
     *
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget4(TreeNode root, int k) {
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
