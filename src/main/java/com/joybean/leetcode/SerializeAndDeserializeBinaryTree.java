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
    /**
     * Memory Limit Exceeded
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
        if (data == "") {
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int x) { val = x; }
    }
}
