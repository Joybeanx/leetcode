package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/merge-two-binary-trees/">Merge Two Binary Trees</a>
 *
 * @author Joybean
 */
public class MergeTwoBinaryTrees {
    /**
     * DFS: always create new TreeNode
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int val = 0;
        TreeNode left1 = null;
        TreeNode left2 = null;
        TreeNode right1 = null;
        TreeNode right2 = null;
        if (root1 != null) {
            val += root1.val;
            left1 = root1.left;
            right1 = root1.right;
        }
        if (root2 != null) {
            val += root2.val;
            left2 = root2.left;
            right2 = root2.right;
        }
        TreeNode root = new TreeNode(val);
        root.left = mergeTrees1(left1, left2);
        root.right = mergeTrees1(right1, right2);
        return root;
    }

    /**
     * DFS: create new TreeNode only if two merging nodes exist
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees2(root1.left, root2.left);
        root.right = mergeTrees2(root1.right, root2.right);
        return root;
    }

    /**
     * DFS: use original TreeNode
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees2(root1.left, root2.left);
        root1.right = mergeTrees2(root1.right, root2.right);
        return root1;
    }

    /**
     * Iterative solution
     * TODO
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees4(TreeNode root1, TreeNode root2) {
        return null;
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
