package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Construct
 * Binary Tree from Inorder and Postorder Traversal</a>
 *
 * @author Joybean
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private static int postorderIdx;

    /**
     * Recursion solution
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree1(int[] inorder, int[] postorder) {
        postorderIdx = postorder.length - 1;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorderMap, postorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(Map<Integer, Integer> inorderMap, int[] postorder, int inorderFrom,
                                      int inorderTo) {
        if (inorderFrom > inorderTo) {
            return null;
        }
        int parentVal = postorder[postorderIdx--];
        int inorderParentIdx = inorderMap.get(parentVal);
        TreeNode parent = new TreeNode(parentVal);
        parent.right = buildTree(inorderMap, postorder, inorderParentIdx + 1, inorderTo);
        parent.left = buildTree(inorderMap, postorder, inorderFrom, inorderParentIdx - 1);
        return parent;
    }

    /**
     * Iterative solution
     * TODO
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
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
