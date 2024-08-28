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
     * DFS: cache one side first
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
     * DFS: compare the left and right subtrees at each level
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        return isSymmetric2(root.left, root.right);
    }

    private boolean isSymmetric2(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            return node1.val == node2.val && isSymmetric2(node1.left, node2.right) && isSymmetric2(node1.right, node2.left);
        }
        if (node1 == null && node2 == null) {
            return true;
        }
        return false;

    }

    /**
     * <a href="https://leetcode.com/problems/minimum-height-trees/solution/">DFS: compare the left and right subtrees at each level</a>
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric3(TreeNode root) {
        return isSymmetric3(root.left, root.right);
    }

    public static boolean isSymmetric3(TreeNode node1, TreeNode node2) {
        //It's pretty nifty here
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        return (node1.val == node2.val)
                && isSymmetric3(node1.right, node2.left)
                && isSymmetric3(node1.left, node2.right);
    }

    /**
     * <a href="https://leetcode.com/problems/symmetric-tree/solutions/33054/recursive-and-non-recursive-solutions-in-java/">Iterative solution with stack</a>
     * TODO
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric4(TreeNode root) {
        return false;
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
