package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/">Recover a Tree From Preorder
 * Traversal</a>
 *
 * @author Joybean
 */
public class RecoverATreeFromPreorderTraversal {
    private static int index = 0;

    /**
     * Recursive solution
     *
     * @param traversal
     * @return
     */
    public static TreeNode recoverFromPreorder1(String traversal) {
        return recoverFromPreorder(traversal, 0);
    }

    public static TreeNode recoverFromPreorder(String traversal, int level) {
        if (!checkNextDash(traversal, level)) {
            return null;
        }
        index += level;
        Integer nextInt = nextInteger(traversal);
        if (nextInt == null) {
            return null;
        }
        TreeNode parent = new TreeNode(nextInt);
        parent.left = recoverFromPreorder(traversal, level + 1);
        parent.right = recoverFromPreorder(traversal, level + 1);
        return parent;
    }

    private static Integer nextInteger(String traversal) {
        int start = index;
        while (index < traversal.length() && traversal.charAt(index) != '-') {
            index++;
        }
        if (index > start) {
            return Integer.parseInt(traversal.substring(start, index));
        }
        return null;
    }

    private static boolean checkNextDash(String traversal, int level) {
        int cnt = 0;
        while (index + cnt < traversal.length() && traversal.charAt(index + cnt) == '-') {
            cnt++;
        }
        return level == cnt;
    }

    /**
     * Iterative Stack Solution
     * TODO
     *
     * @param traversal
     * @return
     */
    public static TreeNode recoverFromPreorder2(String traversal) {
        return null;
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
