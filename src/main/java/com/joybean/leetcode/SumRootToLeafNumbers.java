package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">Sum Root to Leaf Numbers</a>
 *
 * @author Joybean
 */
public class SumRootToLeafNumbers {
    public static int sumNumbers1(TreeNode root) {
        return sumNumbers1(root, 0);
    }

    /*
    //wrong solution, root-to-leaf numbers will sum twice
    public static int sumNumbers(TreeNode curNode, int curNum) {
        if (curNode == null) {
            return curNum;
        }
        int val = curNode.val;
        return sumNumbers(curNode.left, curNum * 10 + val) + sumNumbers(curNode.right, curNum * 10 + val);
    }*/

    /**
     * DFS
     *
     * @param curNode
     * @param curNum
     * @return
     */
    public static int sumNumbers1(TreeNode curNode, int curNum) {
        if (curNode == null) {
            return 0;
        }
        int val = curNode.val;
        curNum = curNum * 10 + val;
        if (curNode.left == null && curNode.right == null) {
            return curNum;
        }
        return sumNumbers1(curNode.left, curNum) + sumNumbers1(curNode.right, curNum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
