package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/recover-binary-search-tree/">Recover Binary Search Tree</a>
 *
 * @author Joybean
 */
public class RecoverBinarySearchTree {
    private static TreeNode maxSwappedNode = new TreeNode(Integer.MIN_VALUE);
    private static TreeNode minSwappedNode = new TreeNode(Integer.MAX_VALUE);

    private static TreeNode first = null;
    private static TreeNode second = null;
    private static TreeNode prev = null;

    /**
     * Preorder traversal:find all out of order nodes and swap the minimum one and the maximum one
     *
     * @param root
     */
    public static void recoverTree1(TreeNode root) {
        List<TreeNode> swapped = findOutOfOrderNodes(root, null, null);
        List<TreeNode> sorted = swapped.stream().sorted(Comparator.comparing(tn -> tn.val)).collect(
            Collectors.toList());
        swap(sorted.get(0), sorted.get(sorted.size() - 1));
    }

    private static List<TreeNode> findOutOfOrderNodes(TreeNode root, TreeNode from, TreeNode to) {
        if (root == null) {
            return null;
        }
        List<TreeNode> ans = new ArrayList<>();
        if (from != null && root.val <= from.val) {
            ans.add(root);
            ans.add(from);
        }
        if (to != null && root.val >= to.val) {
            ans.add(root);
            ans.add(to);
        }
        List<TreeNode> leftResult = findOutOfOrderNodes(root.left, from, root);
        if (leftResult != null) {
            ans.addAll(leftResult);
        }
        List<TreeNode> rightResult = findOutOfOrderNodes(root.right, root, to);
        if (rightResult != null) {
            ans.addAll(rightResult);
        }
        return ans;
    }

    /**
     * Preorder traversal:find and update two swapped nodes while traversing
     *
     * @param root
     */
    public static void recoverTree2(TreeNode root) {
        findSwappedNodes(root, null, null);
        swap(maxSwappedNode, minSwappedNode);
    }

    private static void findSwappedNodes(TreeNode root, TreeNode from, TreeNode to) {
        if (root == null) {
            return;
        }
        if (from != null && root.val <= from.val) {
            maxSwappedNode = maxSwappedNode.val > from.val ? maxSwappedNode : from;
            minSwappedNode = minSwappedNode.val < root.val ? minSwappedNode : root;
        }
        if (to != null && root.val >= to.val) {
            maxSwappedNode = maxSwappedNode.val > root.val ? maxSwappedNode : root;
            minSwappedNode = minSwappedNode.val < to.val ? minSwappedNode : to;
        }
        findSwappedNodes(root.left, from, root);
        findSwappedNodes(root.right, root, to);
    }

    /**
     * Inorder traversal
     *
     * @param root
     */
    public static void recoverTree3(TreeNode root) {
        inorderTraverse(root);
        swap(first, second);
    }

    private static void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        //We should take advantage of this fact that,the output of normal BST inorder traversal should be ordered
        //For example: [6, 3, 4, 5, 2] because 6>3, 5>2, so 6 is the first node, 2 is the second node
        if (first == null && prev != null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        inorderTraverse(root.right);
    }

    /**
     * Morris traversal
     * TODO
     * @param root
     */
    public static void recoverTree4(TreeNode root) {

    }

    private static void swap(TreeNode one, TreeNode another) {
        int tmp = one.val;
        one.val = another.val;
        another.val = tmp;
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
