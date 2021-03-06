package com.joybean.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary
 * Tree</a>
 *
 * @author Joybean
 */
public class SerializeAndDeserializeBinaryTree {
    private static int index;

    /**
     * Fill perfect binary tree:Memory Limit Exceeded
     *
     * @param root
     * @return
     */
    public static String serialize1(TreeNode root) {
        if (root == null) {
            return "";
        }

        int height = getHeight(root);
        String[] arr = new String[(int)Math.pow(2, height) - 1];
        List<String> list = Arrays.asList(arr);
        serialize(root, 0, Arrays.asList(arr));
        return list.stream().collect(Collectors.joining(","));
    }

    private static void serialize(TreeNode root, int index, List<String> list) {
        if (root == null) {
            return;
        }
        list.set(index, String.valueOf(root.val));
        serialize(root.left, 2 * index + 1, list);
        serialize(root.right, 2 * index + 2, list);
    }

    public static TreeNode deserialize1(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        return buildTree(arr, 0);
    }

    private static TreeNode buildTree(String[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        if (arr[index].equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        node.left = buildTree(arr, 2 * index + 1);
        node.right = buildTree(arr, 2 * index + 2);
        return node;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * Preorder traversal
     *
     * @param root
     * @return
     */
    public static String serialize2(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        inorderSerialize(root, sb);
        return sb.toString();

    }

    private static void inorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        inorderSerialize(root.left, sb);
        inorderSerialize(root.right, sb);
    }

    public static TreeNode deserialize2(String data) {
        String[] values = data.split(",");
        return inorderDeserialize(values);
    }

    private static TreeNode inorderDeserialize(String[] values) {
        if (index > values.length - 1) {
            return null;
        }
        String val = values[index];
        index++;
        if (val.equals("#")) {
            return null;
        }
        TreeNode parent = new TreeNode(Integer.parseInt(val));
        parent.left = inorderDeserialize(values);
        parent.right = inorderDeserialize(values);
        return parent;
    }

    /**
     * Postorder traversal
     *
     * @param root
     * @return
     */
    public static String serialize3(TreeNode root) {
        return null;

    }

    public static TreeNode deserialize3(String data) {
        return null;
    }

    /**
     * Level order traversal
     *
     * @param root
     * @return
     */
    public static String serialize4(TreeNode root) {
        return null;

    }

    public static TreeNode deserialize4(String data) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int x) { val = x; }
    }
}
