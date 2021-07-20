package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">Unique Binary Search Trees II</a>
 *
 * @author Joybean
 */
public class UniqueBinarySearchTrees2 {
    /**
     * Ugly recursive solution
     *
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees1(int n) {
        return generateTrees1(1, n);
    }

    public static List<TreeNode> generateTrees1(int from, int to) {
        if (from > to) {
            return new ArrayList<>();
        }
        if (from == to) {
            return Collections.singletonList(new TreeNode(from));
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            List<TreeNode> leftTrees = generateTrees1(from, i - 1);
            List<TreeNode> rightTrees = generateTrees1(i + 1, to);
            if (!leftTrees.isEmpty() && !rightTrees.isEmpty()) {
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode parent = new TreeNode(i);
                        parent.left = leftTree;
                        parent.right = rightTree;
                        list.add(parent);
                    }
                }
            } else if (leftTrees.isEmpty()) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode parent = new TreeNode(i);
                    parent.right = rightTree;
                    list.add(parent);
                }
            } else {
                for (TreeNode leftTree : leftTrees) {
                    TreeNode parent = new TreeNode(i);
                    parent.left = leftTree;
                    list.add(parent);
                }
            }
        }
        return list;
    }

    /**
     * Better recursive solution
     *
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees2(int n) {
        return generateTrees2(1, n);
    }

    public static List<TreeNode> generateTrees2(int from, int to) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (from > to) {
            //Add null to result can reduce if branch
            treeNodes.add(null);
            return treeNodes;
        }
        if (from == to) {
            treeNodes.add(new TreeNode(from));
            return treeNodes;
        }
        for (int i = from; i <= to; i++) {
            List<TreeNode> leftTrees = generateTrees2(from, i - 1);
            List<TreeNode> rightTrees = generateTrees2(i + 1, to);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode parent = new TreeNode(i);
                    parent.left = leftTree;
                    parent.right = rightTree;
                    treeNodes.add(parent);
                }
            }
        }
        return treeNodes;
    }

    /**
     * Best recursive solution
     *
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees3(int n) {
        return generateTrees3(1, n);
    }

    public static List<TreeNode> generateTrees3(int from, int to) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (from > to) {
            treeNodes.add(null);
        }
        for (int i = from; i <= to; i++) {
            for (TreeNode leftTree : generateTrees3(from, i - 1)) {
                for (TreeNode rightTree : generateTrees3(i + 1, to)) {
                    TreeNode parent = new TreeNode(i);
                    parent.left = leftTree;
                    parent.right = rightTree;
                    treeNodes.add(parent);
                }
            }
        }
        return treeNodes;
    }

    /**
     * DP solution
     * TODO
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees4(int n) {
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
