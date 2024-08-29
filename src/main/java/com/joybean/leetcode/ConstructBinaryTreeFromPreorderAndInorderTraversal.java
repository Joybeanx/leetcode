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

    /*
    //wrong solution, failed case: preorder = {3, 2, 1, 4}; inorder = {1, 2, 3, 4};
    private static int rootIdx = 0;
    public static TreeNode buildTree2(int[] preorder, int start, int end,
        Map<Integer, Integer> inorderMap) {
        if (start > end) {
            return null;
        }

        int parentVal = preorder[rootIdx];
        TreeNode parent = new TreeNode(parentVal);

        if (rootIdx + 1 < preorder.length && inorderMap.get(preorder[rootIdx + 1]) < inorderMap.get(parentVal)) {
            rootIdx++;
            parent.left = buildTree2(preorder, start, inorderMap.get(parentVal) - 1, inorderMap);
        }
        if (rootIdx + 1 < preorder.length && inorderMap.get(preorder[rootIdx + 1]) > inorderMap.get(parentVal)) {
            rootIdx++;
            parent.right = buildTree2(preorder, inorderMap.get(parentVal) + 1, end, inorderMap);
        }
        return parent;
    }
    */

    private static int preorderIdx = 0;

    /**
     * Recursive solution: inorderMap + global preorder index
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree1(0, inorder.length - 1, preorder, inorderMap);
    }

    private static TreeNode buildTree1(int inorderStart, int inorderEnd, int[] preorder,
                                       Map<Integer, Integer> inorderMap) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int val = preorder[preorderIdx++];
        TreeNode root = new TreeNode(val);
        root.left = buildTree1(inorderStart, inorderMap.get(val) - 1, preorder, inorderMap);
        root.right = buildTree1(inorderMap.get(val) + 1, inorderEnd,
                preorder, inorderMap);
        return root;
    }

    /**
     * Recursive solution: inorderMap + preorder index variable
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree2(preorder, new AtomicInteger(0), 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode buildTree2(int[] preorder, AtomicInteger preorderIndex, int inorderStart, int inorderEnd,
                                       Map<Integer, Integer> inorderMap) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int parentVal = preorder[preorderIndex.getAndIncrement()];
        TreeNode parent = new TreeNode(parentVal);
        int inorderParentIdx = inorderMap.get(parentVal);
        parent.left = buildTree2(preorder, preorderIndex, inorderStart, inorderParentIdx - 1, inorderMap);
        parent.right = buildTree2(preorder, preorderIndex, inorderParentIdx + 1, inorderEnd, inorderMap);
        return parent;
    }

    /**
     * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions
     * /34538/my-accepted-java-solution/">Optimized recursive solution: calculate preorder index from inorder index</a>
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree3(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree3(preorder, 0, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode buildTree3(int[] preorder, int preorderIndex, int inorderStart, int inorderEnd,
                                       Map<Integer, Integer> inorderMap) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int parentVal = preorder[preorderIndex];
        TreeNode parent = new TreeNode(parentVal);
        int inorderParentIdx = inorderMap.get(parentVal);
        parent.left = buildTree3(preorder, preorderIndex + 1, inorderStart, inorderParentIdx - 1, inorderMap);
        //calculate preorderIndex for right subtree after left subtree is built
        //     3
        //    / \
        //   2   4
        //  /
        // 1
        //inorder = {1,2,3,4}
        //preorder = {3,2,1,4}
        parent.right = buildTree3(preorder, preorderIndex + inorderParentIdx - inorderStart + 1, inorderParentIdx + 1,
                inorderEnd, inorderMap);
        return parent;
    }

    /**
     * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/34543/simple-o-n-without-map/">Recursive solution: no extra space</a>
     * TODO
     *
     * @param preorder
     * @param inorder
     * @return
     */


    public static TreeNode buildTree4(int[] preorder, int[] inorder) {
        return  null;
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
