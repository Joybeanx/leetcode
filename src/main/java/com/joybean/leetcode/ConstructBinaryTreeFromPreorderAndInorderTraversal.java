package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct
 * Binary Tree from Preorder and Inorder Traversal</a>
 *
 * @author Joybean
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * Recursion
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, new AtomicInteger(0), 0, preorder.length - 1, inorderMap);
    }

    private TreeNode buildTree(int[] preorder, AtomicInteger preorderIndex, int left, int right, Map<Integer,
        Integer> inorderMap) {
        if (left > right) {
            return null;
        }
        int parentVal = preorder[preorderIndex.getAndIncrement()];
        TreeNode parent = new TreeNode(parentVal);
        parent.left = buildTree(preorder, preorderIndex,left, inorderMap.get(parentVal) - 1, inorderMap);
        parent.right = buildTree(preorder, preorderIndex,inorderMap.get(parentVal) + 1, right, inorderMap);
        return parent;
    }

    public class TreeNode {
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
