package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-bst/">Delete Node in a BST</a>
 *
 * @author Joybean
 */
public class DeleteNodeInABST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            //root has two children,replace root with root.right's left most node or root.left's right most node
            TreeNode leftMostNodeOfRightChild = leftMostNode(root.right);
            root.val = leftMostNodeOfRightChild.val;
            root.right = deleteNode(root.right, leftMostNodeOfRightChild.val);
        }
        return root;
    }

    public static TreeNode leftMostNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
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
