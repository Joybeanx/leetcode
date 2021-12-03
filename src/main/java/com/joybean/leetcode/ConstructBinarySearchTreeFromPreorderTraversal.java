package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/">Construct Binary Search
 * Tree from Preorder Traversal</a>
 *
 * @author Joybean
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    private static int curIndex;

    /**
     * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252754
     * /Java-Stack-Iterative-Solution">Stack solution</a>
     *
     * @param preorder
     * @return
     */
    public static TreeNode bstFromPreorder1(int[] preorder) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = stack.pop();
                //Keep popping until find the parent of current num
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }

    /**
     * Recursive solution
     *
     * @param preorder
     * @return
     */
    public static TreeNode bstFromPreorder2(int[] preorder) {
        return bstFromPreorder(preorder, -1, Integer.MAX_VALUE);
    }

    private static TreeNode bstFromPreorder(int[] preorder, int min, int max) {
        if (curIndex == preorder.length) {
            return null;
        }
        if (preorder[curIndex] < min || preorder[curIndex] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[curIndex++]);
        root.left = bstFromPreorder(preorder, min, root.val);
        root.right = bstFromPreorder(preorder, root.val, max);
        return root;
    }

    /**
     * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252232
     * /JavaC%2B%2BPython-O(N)-Solution">Optimized recursive solution</a>
     *
     * @param preorder
     * @return
     */
    public static TreeNode bstFromPreorder3(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private static TreeNode bstFromPreorder(int[] preorder, int max) {
        if (curIndex == preorder.length || preorder[curIndex] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[curIndex++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, max);
        return root;
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
