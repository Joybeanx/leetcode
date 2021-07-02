package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-bst/">Serialize and Deserialize BST</a>
 *
 * @author Joybean
 */
public class SerializeAndDeserializeBST {
    private static int index;

    /**
     * Preorder traversal using array
     *
     * @param root
     * @return
     */
    public static String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inorderSerialize(root, sb);
        return sb.toString();
    }

    private static void inorderSerialize(TreeNode root, StringBuilder sb) {
        //No null placeholder
        if (root == null) {
            return;
        }
        sb.append(root.val);
        sb.append(",");
        inorderSerialize(root.left, sb);
        inorderSerialize(root.right, sb);
    }

    public static TreeNode deserialize1(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] values = data.split(",");
        return inorderDeserialize(values, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode inorderDeserialize(String[] values, int lower, int upper) {
        if (index > values.length - 1) {
            return null;
        }
        int val = Integer.parseInt(values[index]);
        //Use upper and lower boundaries to check whether we should add null
        if (val < lower || val > upper) {
            return null;
        }
        index++;
        TreeNode parent = new TreeNode(val);
        parent.left = inorderDeserialize(values, lower, val);
        parent.right = inorderDeserialize(values, val, upper);
        return parent;
    }

    /**
     * Preorder traversal using queue
     * TODO
     * @param root
     * @return
     */
    public static String serialize2(TreeNode root) {
        return null;
    }

    public static TreeNode deserialize2(TreeNode root) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
    }
}
