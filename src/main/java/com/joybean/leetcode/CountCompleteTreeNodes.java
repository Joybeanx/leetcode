package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes/">Count Complete Tree Nodes</a>
 *
 * @author Joybean
 */
public class CountCompleteTreeNodes {
    private static int missingNodes;

    /**
     * Reverse preorder traversal: perfectBinaryTreeNodes - missingNodes
     *
     * @param root
     * @return
     */
    public static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxHeight = 0;
        TreeNode left = root;
        while (left != null) {
            maxHeight++;
            left = left.left;
        }
        countPerfectBinaryTreeMissingNodes(root, 1, maxHeight);
        int perfectBinaryTreeNodes = (1 << maxHeight) - 1;
        return perfectBinaryTreeNodes - missingNodes;
    }

    private static boolean countPerfectBinaryTreeMissingNodes(TreeNode root, int curHeight, int maxHeight) {
        if (curHeight == maxHeight) {
            if (root == null) {
                missingNodes++;
                return false;
            } else {
                //We had found all missing nodes
                return true;
            }
        }
        return countPerfectBinaryTreeMissingNodes(root.right, curHeight + 1, maxHeight)
            || countPerfectBinaryTreeMissingNodes(
            root.left, curHeight + 1, maxHeight);
    }

    /**
     * https://leetcode.com/problems/count-complete-tree-nodes/discuss/61948/Accepted-Easy-Understand-Java-Solution
     *
     * @param root
     * @return
     */
    public static int countNodes2(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        //Root presents a perfect binary tree
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes2(root.left) + countNodes2(root.right);
        }

    }

    private static int rightDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private static int leftDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
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
