package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/convert-bst-to-greater-tree/description/">Convert BST to Greater Tree</a>
 *
 * @author Joybean
 */
public class ConvertBSTToGreaterTree {
    /**
     * Reversed inorder traversal
     *
     * @param root
     * @return
     */
    public static TreeNode convertBST1(TreeNode root) {
        //sum of keys greater than the smallest key in root
        sumOfTree1(root, 0);
        return root;
    }

    private static int sumOfTree1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int right = sumOfTree1(root.right, sum);
        int rootVal = root.val;
        root.val = right + root.val + sum;
        int left = sumOfTree1(root.left, root.val);
        return right + rootVal + left;
    }

    /**
     *
     * <a href="https://leetcode.com/problems/convert-bst-to-greater-tree/solutions/100506/java-recursive-o-n-time/">Reversed inorder traversal(by yellowstone)</a>
     *
     * @param root
     * @return
     */
    public static TreeNode convertBST2(TreeNode root) {
        //sum of keys greater than the smallest key in root
        sumofTree2(root, 0);
        return root;
    }

    private static int sumofTree2(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int right = sumofTree2(root.right, sum);
        root.val = root.val + right;
        int left = sumOfTree1(root.left, root.val);
        return left;
    }

    public class TreeNode {
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
