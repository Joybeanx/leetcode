package com.joybean.leetcode;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest Element in a BST</a>
 *
 * @author Joybean
 */
public class KthSmallestElementInABST {
    private static int traversed;
    private static int ans;

    /**
     * DFS using global variables
     *
     * @param root
     * @param k
     */
    public static int kthSmallest1(TreeNode root, int k) {
        kthSmallestInternal1(root, k);
        return ans;
    }


    private static void kthSmallestInternal1(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallestInternal1(root.left, k);
        if (++traversed == k) {
            ans = root.val;
            return;
        }
        kthSmallestInternal1(root.right, k);
    }

    /**
     * DFS without global variables
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest2(TreeNode root, int k) {
        return kthSmallestInternal2(root, new AtomicInteger(k));
    }

    private static Integer kthSmallestInternal2(TreeNode curNode, AtomicInteger cnt) {
        if (curNode == null) {
            return null;
        }

        Integer value = kthSmallestInternal2(curNode.left, cnt);
        if (value != null) {
            return value;
        }
        cnt.decrementAndGet();
        if (cnt.get() == 0) {
            return curNode.val;
        }
        return kthSmallestInternal2(curNode.right, cnt);
    }

    /**
     * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/solutions/63660/3-ways-implemented-in-java-python-binary-search-in-order-iterative-recursive/">Binary search + DFS</a>
     * TODO
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest3(TreeNode root, int k) {
        return 0;
    }

    /**
     * Iterative solution
     *
     * @param root
     * @param k
     */
    private static int kthSmallest4(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (true) {
            pushToStack(root, stack);
            if (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                if (++count == k) {
                    return current.val;
                }
                root = current.right;
            } else {
                break;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static void pushToStack(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
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
