package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/">Symmetric Tree</a>
 *
 * @author Joybean
 */
public class SymmetricTree {
    private static List<Integer> leftTreeNodes;
    private static int index;

    /**
     * DFS:cache one side first
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        leftTreeNodes = new ArrayList<>();
        preorderTraversal(root.left);
        return isSymmetricInternal(root.right);
    }

    private static void preorderTraversal(TreeNode root) {
        if (root == null) {
            leftTreeNodes.add(null);
            return;
        }
        leftTreeNodes.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private static boolean isSymmetricInternal(TreeNode root) {
        Integer opposite = leftTreeNodes.get(index++);
        if (root == null) {
            return opposite == null;
        }
        if (opposite == null || root.val != opposite) {
            return false;
        }
        return isSymmetricInternal(root.right) && isSymmetricInternal(root.left);
    }

    /**
     * <a href="https://leetcode.com/problems/minimum-height-trees/solution/">Better DFS</a>
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        //It's pretty nifty here
        if (t1 == null || t2 == null) {
            return t1 == t2;
        }
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }

    /**
     * Iterative solution
     * TODO
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric3(TreeNode root) {
        return false;
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
